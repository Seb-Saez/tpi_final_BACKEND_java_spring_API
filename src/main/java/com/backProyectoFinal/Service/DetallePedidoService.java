package com.backProyectoFinal.Service;

import java.util.List;

import com.backProyectoFinal.Entity.DetallePedido;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoCreate;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoDto;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoEdit;

public interface DetallePedidoService {

    public DetallePedidoDto crear(DetallePedidoCreate dto);

    
    public DetallePedidoDto edit(Long id, DetallePedidoEdit dto);

    
    public DetallePedidoDto buscaId(Long id);

    
    public List<DetallePedidoDto> traerTodos();

    
    public void eliminar(Long id);
}
