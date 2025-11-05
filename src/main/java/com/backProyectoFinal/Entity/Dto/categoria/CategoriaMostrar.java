package com.backProyectoFinal.Entity.Dto.categoria;

import java.util.Set;


import com.backProyectoFinal.Entity.Dto.producto.ProductoMostrar;

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
public class CategoriaMostrar {
 private String imagen;
    private String nombre;
    private String descripcion;

    private Set<ProductoMostrar> productos;
}
