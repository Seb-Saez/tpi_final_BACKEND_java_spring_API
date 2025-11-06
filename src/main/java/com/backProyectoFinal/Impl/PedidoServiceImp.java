package com.backProyectoFinal.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backProyectoFinal.Entity.DetallePedido;
import com.backProyectoFinal.Entity.Pedido;
import com.backProyectoFinal.Entity.Usuario;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoCreate;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoDto;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoEdit;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;
import com.backProyectoFinal.Entity.Mapper.DetallePedidoMapper;
import com.backProyectoFinal.Entity.Mapper.PedidoMapper;
import com.backProyectoFinal.Entity.Mapper.ProductoMapper;
import com.backProyectoFinal.Repository.PedidoRepository;
import com.backProyectoFinal.Repository.UsuarioRepository;
import com.backProyectoFinal.Service.PedidoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoServiceImp implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;
    private UsuarioRepository usuarioRepository;
   
    @Override
    public PedidoDto crear(Long idCliente, PedidoCreate dto) {

        Usuario usuario = usuarioRepository.findById(idCliente)
            .orElseThrow(()->new EntityNotFoundException("No se encontro un cliente con el id: " + idCliente));
    
            if(dto.getDetalles()==null || dto.getDetalles().isEmpty()){
                throw new IllegalArgumentException("No se puede crear un pedido sin detalles");
            }
        Pedido pedido = PedidoMapper.toEntity(dto);

        // Creo los detalles y calculo el subtotal
        List<DetallePedido> detalles = dto.getDetalles().stream()
            .map(detalleDto->{
                DetallePedido detalle = new DetallePedido();
                detalle.setCantidad(detalleDto.getCantidad());
                detalle.setProducto(ProductoMapper.toEntity(detalleDto.getProductoDto()));
                detalle.setSubtotal(detalle.getCantidad() * detalle.getProducto().getPrecio());
                return detalle;
            })
            .toList();
        pedido.setDetalles(detalles);

        // Calculamos y setteamos el total del pedido con stream B)
        double total = pedido.getDetalles().stream()
            .mapToDouble(DetallePedido::getSubtotal)
            .sum();

        pedido.setTotal(total);
        pedidoRepository.save(pedido);
        usuario.getPedidos().add(pedido);
        usuarioRepository.save(usuario);

        return PedidoMapper.toDto(pedido);

    }

    @Override
    public PedidoDto edit(Long id, PedidoEdit dto) {

     Pedido pedido = buscarPorId(id);
        if(dto.getEstado()==null || dto.getDetalles()==null){throw new IllegalArgumentException("Por favor ingrese un estado de pedido y sus detalles");}
        if(dto.getDetalles().isEmpty()){ throw new IllegalArgumentException("La lista de detalles debe contener al menos un elemento");}
     pedido.setEstado(dto.getEstado());

     // Vaciamos la lista ctual y cargamos uno por uno los detalles, para evitar problemas por la relacion
    pedido.getDetalles().clear();
    for (DetallePedido detalle : dto.getDetalles().stream().map(DetallePedidoMapper::toEntity).toList()) {
        pedido.getDetalles().add(detalle);
    }
     // Calculamos y setteamos el total del pedido
        double total = 0;
        for(DetallePedido d : pedido.getDetalles()){
            total += d.getSubtotal();
        }
        pedido.setTotal(total);
     pedidoRepository.save(pedido);
     return PedidoMapper.toDto(pedido);
    }

    @Override
    public PedidoDto buscaId(Long id) {
        Pedido pedido = buscarPorId(id);
        return PedidoMapper.toDto(pedido);
    }

    @Override
    public List<PedidoDto> traerTodos() {
      List<Pedido> pedidos = pedidoRepository.findByEliminadoFalse();
      return pedidos.stream().map(PedidoMapper::toDto).toList();
    }


    @Override
    public void eliminar(Long id) {
      Pedido pedido = buscarPorId(id);
      pedido.setEliminado(true);
      pedidoRepository.save(pedido);
    }

 

    @Override
    public List<PedidoDto> buscarPorEstado(EstadoPedido estado) {
        List<Pedido> pedidos = pedidoRepository.findByEstado(estado);
        return pedidos.stream().map(PedidoMapper::toDto).toList();
    }

    //-------------------------------------------------------------------------------------
    // creo un metodo extra para cambiar el estado
    //-------------------------------------------------------------------------------------
    @Override
    public PedidoDto cambiarEstado(Long id, EstadoPedido estado){
        Pedido pedido = buscarPorId(id);
        if (pedido.getEstado() == estado) {
            throw new IllegalArgumentException("El pedido ya se encuentra en el estado " + estado);
            }
        pedido.setEstado(estado);
        pedidoRepository.save(pedido);
        return PedidoMapper.toDto(pedido);
    }

      // Metodo para buscar por ID, con manejo de error
    public Pedido buscarPorId(Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Pedido no encontrado con el id: " + id));
        return pedido;
    }
}
