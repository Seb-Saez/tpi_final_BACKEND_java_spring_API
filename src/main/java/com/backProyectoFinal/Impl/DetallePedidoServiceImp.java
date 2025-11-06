package com.backProyectoFinal.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backProyectoFinal.Entity.Categoria;
import com.backProyectoFinal.Entity.DetallePedido;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoCreate;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoDto;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoEdit;
import com.backProyectoFinal.Entity.Mapper.DetallePedidoMapper;
import com.backProyectoFinal.Repository.DetallePedidoRepository;
import com.backProyectoFinal.Service.DetallePedidoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DetallePedidoServiceImp implements DetallePedidoService{

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public DetallePedidoDto crear(DetallePedidoCreate dto) {
        if(dto.getProducto()!=null && dto.getCantidad()>0){
            DetallePedido detallePedido = DetallePedidoMapper.toEntity(dto);
            detallePedido.setSubtotal(detallePedido.getCantidad() * detallePedido.getProducto().getPrecio());

            detallePedidoRepository.save(detallePedido);
            return DetallePedidoMapper.toDto(detallePedido);   
        } else{
            throw new IllegalArgumentException("No se puede crear un detalle sin un producto o con cantidad menor a 1");
        }
        
    }

    @Override
    public DetallePedidoDto edit(Long id, DetallePedidoEdit dto) {

          if(dto.getProducto()!=null && dto.getCantidad()>0){
            DetallePedido detallePedido = buscarPorId(id);
            detallePedido.setCantidad(dto.getCantidad());
            detallePedido.setProducto(dto.getProducto());
            detallePedido.setSubtotal(detallePedido.getCantidad() * detallePedido.getProducto().getPrecio());

            detallePedidoRepository.save(detallePedido);
            return DetallePedidoMapper.toDto(detallePedido);   
        } else{
            throw new IllegalArgumentException("Debe indicar un producto válido y una cantidad mayor que 0");
        }

    }

    @Override
    public DetallePedidoDto buscaId(Long id) {
        DetallePedido detallePedido = buscarPorId(id);
        return DetallePedidoMapper.toDto(detallePedido);

    }

    @Override
    public List<DetallePedidoDto> traerTodos() {
       List<DetallePedido> detalles = detallePedidoRepository.findByEliminadoFalse();
       return detalles.stream().map(DetallePedidoMapper::toDto).toList();
    }

    @Override
    public void eliminar(Long id) {
        DetallePedido detallePedido = buscarPorId(id);
        detallePedido.setEliminado(true);
        detallePedidoRepository.save(detallePedido);
        }

    // Metodo para buscar por ID, con manejo de error
      public DetallePedido buscarPorId(Long id){
        DetallePedido detallePedido = detallePedidoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("DetallePedido no encontrado con el id: " + id));
        return detallePedido;
    }
}
