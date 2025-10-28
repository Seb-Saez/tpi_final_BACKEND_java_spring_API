package com.backProyectoFinal.Entity.Dto.producto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoCreate {
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    private int stock;
}
