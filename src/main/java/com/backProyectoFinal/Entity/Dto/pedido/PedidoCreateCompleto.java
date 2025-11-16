package com.backProyectoFinal.Entity.Dto.pedido;

import com.backProyectoFinal.Entity.Dto.infoEntrega.InfoEntregaCreate;

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
public class PedidoCreateCompleto {
    private PedidoCreate dto;
    private InfoEntregaCreate infoEntrega;
}
