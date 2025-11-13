package com.backProyectoFinal.Entity.Mapper;

import com.backProyectoFinal.Entity.DetallePedido;
import com.backProyectoFinal.Entity.Producto;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoCreate;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoDto;

public class DetallePedidoMapper {

    public static DetallePedido toEntity (DetallePedidoCreate dto){
            Producto producto = new Producto();
            producto.setId(dto.getProductoId());

            return new DetallePedido().builder()
                .cantidad(dto.getCantidad())
                .producto(producto)
                .build();
    }

    public static DetallePedido toEntity (DetallePedidoDto dto){

        return new DetallePedido().builder()
            .cantidad(dto.getCantidad())
            .producto(ProductoMapper.toEntity(dto.getProductoDto()))
            .build();
    }

    public static DetallePedidoDto toDto(DetallePedido d){
        return new DetallePedidoDto().builder()
            .id(d.getId())
            .cantidad(d.getCantidad())
            .productoDto(ProductoMapper.toDto(d.getProducto()))
            .subtotal(d.getSubtotal())
            .build();
    }
}
