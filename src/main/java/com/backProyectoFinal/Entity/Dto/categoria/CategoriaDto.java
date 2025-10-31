package com.backProyectoFinal.Entity.Dto.categoria;

import com.backProyectoFinal.Entity.Producto;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDto {
    private Long id;
    private String imagen;
    private String nombre;
    private String descripcion;

    private Set<ProductoDto> productos;
}
