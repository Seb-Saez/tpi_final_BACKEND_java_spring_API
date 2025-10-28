package com.backProyectoFinal.Entity.Dto.categoria;

import lombok.*;

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
}
