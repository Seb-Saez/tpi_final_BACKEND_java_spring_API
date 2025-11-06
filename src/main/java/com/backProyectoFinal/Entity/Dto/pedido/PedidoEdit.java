package com.backProyectoFinal.Entity.Dto.pedido;

import java.util.List;

import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoDto;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoEdit {

    private EstadoPedido estado;
    private List <DetallePedidoDto> detalles;
}
