package com.backProyectoFinal.Service;

import java.util.List;

import com.backProyectoFinal.Entity.Dto.pedido.PedidoCreate;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoDto;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoEdit;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;



public interface PedidoService {

      public PedidoDto crear(Long idCliente, PedidoCreate dto);
    public PedidoDto edit(Long id, PedidoEdit dto);
    public PedidoDto buscaId(Long id);
    public List<PedidoDto> traerTodos();
    public void eliminar(Long id);
    public List<PedidoDto> buscarPorEstado(EstadoPedido estado);
    public PedidoDto cambiarEstado(Long id, EstadoPedido estado);

}
