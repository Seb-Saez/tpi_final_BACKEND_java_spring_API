package com.backProyectoFinal.Entity.Mapper;

import com.backProyectoFinal.Entity.Categoria;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaCreate;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaDto;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaEdit;

public class CategoriaMapper {

    public static CategoriaDto toDto(Categoria c){

        return new CategoriaDto().builder()
                .id(c.getId())
                .imagen(c.getImagen())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())
                .build();
    }
    public static Categoria toEntity (CategoriaCreate dto) {

        return  new Categoria().builder()
                .nombre(dto.getNombre())
                .imagen(dto.getImagen())
                .descripcion(dto.getDescripcion())
                .build();

    }

    // DTO para edit preguntar al profe si esto
/*
    public static CategoriaEdit toDtoEdit(Categoria c){

        return new CategoriaEdit().builder()
                .imagen(c.getImagen())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())
                .build();
    }
*/



}
