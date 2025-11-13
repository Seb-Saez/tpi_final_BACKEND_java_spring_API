package com.backProyectoFinal.Entity.Dto.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoCreate;
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
public class PedidoCreate {

    private List<DetallePedidoCreate> detalles = new ArrayList<>();
}
