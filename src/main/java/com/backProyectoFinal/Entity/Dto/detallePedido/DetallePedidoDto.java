package com.backProyectoFinal.Entity.Dto.detallePedido;

import com.backProyectoFinal.Entity.Producto;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class DetallePedidoDto {

    private Long id;
    private int cantidad;
    private double subtotal;
    private ProductoDto productoDto;
}
