package com.backProyectoFinal.Entity.Dto.categoria;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaCreate {
    private String nombre;
    private String imagen;
    private String descripcion;



}
