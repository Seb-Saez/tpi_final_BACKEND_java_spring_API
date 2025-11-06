package com.backProyectoFinal.Entity.Dto.detallePedido;

import com.backProyectoFinal.Entity.Producto;

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
public class DetallePedidoCreate {
    
    private int cantidad;
    private Producto producto;
}
