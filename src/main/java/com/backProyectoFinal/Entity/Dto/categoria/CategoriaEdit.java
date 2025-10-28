package com.backProyectoFinal.Entity.Dto.categoria;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEdit {
    private String nombre;
    private String imagen;
    private String descripcion;
}
