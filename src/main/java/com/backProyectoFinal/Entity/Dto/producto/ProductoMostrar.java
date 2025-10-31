package com.backProyectoFinal.Entity.Dto.producto;

import com.backProyectoFinal.Entity.Enum.EstadoProducto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoMostrar {

    private String nombre;
    private String descripcion;
    private String imagen;
    private  double precio;
    private int stock;
    private EstadoProducto estado;
}
