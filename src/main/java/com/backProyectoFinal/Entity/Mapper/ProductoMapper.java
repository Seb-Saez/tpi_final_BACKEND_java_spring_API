package com.backProyectoFinal.Entity.Mapper;

import com.backProyectoFinal.Entity.Dto.producto.ProductoCreate;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;
import com.backProyectoFinal.Entity.Dto.producto.ProductoMostrar;
import com.backProyectoFinal.Entity.Producto;

public class ProductoMapper {
    public static ProductoDto toDto(Producto p){
        return new ProductoDto().builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .descripcion(p.getDescripcion())
                .imagen(p.getImagen())
                .precio(p.getPrecio())
                .stock(p.getStock())
                .estado(p.getEstado())
                .build();
    }

    public static Producto toEntity(ProductoCreate dto){
        return new Producto().builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .imagen(dto.getImagen())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .build();
    }

     public static Producto toEntity(ProductoDto dto){
        return new Producto().builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .imagen(dto.getImagen())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .estado(dto.getEstado())
                .build();
    }


     public static ProductoMostrar toDtoMostrar(Producto p){
        return new ProductoMostrar().builder()
                .nombre(p.getNombre())
                .descripcion(p.getDescripcion())
                .imagen(p.getImagen())
                .precio(p.getPrecio())
                .stock(p.getStock())
                .estado(p.getEstado())
                .build();
    }




}
