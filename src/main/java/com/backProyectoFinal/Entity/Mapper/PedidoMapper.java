package com.backProyectoFinal.Entity.Mapper;


import java.util.stream.Collectors;

import com.backProyectoFinal.Entity.Pedido;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoCreate;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoDto;

public class PedidoMapper {

    public static Pedido toEntity (PedidoCreate dto){
        return new Pedido().builder()
            .detalles(dto.getDetalles().stream()
                .map(DetallePedidoMapper::toEntity)
                .toList())
            .build();
    }

    public static PedidoDto toDto (Pedido p){
        return new PedidoDto().builder()
            .id(p.getId())
            .fecha(p.getFecha())
            .estado(p.getEstado())
            .total(p.getTotal())
            .detalles(p.getDetalles().stream()
                .map(DetallePedidoMapper::toDto)
                .collect(Collectors.toList())
                )
            .build();
    }
}
/*  private Long id;
    private String fecha;
    private EstadoPedido estado;
    private double total;
    private List <DetallePedidoDto> pedidos; */