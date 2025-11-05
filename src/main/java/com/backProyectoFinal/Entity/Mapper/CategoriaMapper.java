package com.backProyectoFinal.Entity.Mapper;

import java.util.stream.Collectors;

import com.backProyectoFinal.Entity.Categoria;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaCreate;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaDto;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaEdit;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaMostrar;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;

public class CategoriaMapper {

    public static CategoriaDto toDto(Categoria c){
        if(c.getProductos()!=null){
            return new CategoriaDto().builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .imagen(c.getImagen())
                .descripcion(c.getDescripcion())
                .productos(c.getProductos().stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toSet()))
                .build();
        }  else{
            return new CategoriaDto().builder()
                .id(c.getId())
                .imagen(c.getImagen())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())
                .build();
        }
        }

    public static Categoria toEntity (CategoriaCreate dto) {

        return  new Categoria().builder()
                .nombre(dto.getNombre())
                .imagen(dto.getImagen())
                .descripcion(dto.getDescripcion())
                .build();

    }
    public static CategoriaMostrar toDtoMostrar(Categoria c) {
           return new CategoriaMostrar().builder()
                .imagen(c.getImagen())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())

                .productos(c.getProductos().stream()
                .map(ProductoMapper::toDtoMostrar)
                .collect(Collectors.toSet()))
                .build();
    }
    }






