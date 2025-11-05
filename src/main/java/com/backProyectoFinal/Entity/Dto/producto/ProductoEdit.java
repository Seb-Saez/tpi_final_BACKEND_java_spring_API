package com.backProyectoFinal.Entity.Dto.producto;

import com.backProyectoFinal.Entity.Enum.EstadoProducto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoEdit {
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    private int stock;
    private EstadoProducto estado;
}
