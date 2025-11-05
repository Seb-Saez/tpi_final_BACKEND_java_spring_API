package com.backProyectoFinal.Entity.Dto.pedido;

import java.time.LocalDate;

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

    private double total;
}
