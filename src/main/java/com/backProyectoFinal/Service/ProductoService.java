package com.backProyectoFinal.Service;

import com.backProyectoFinal.Entity.Dto.producto.ProductoCreate;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;
import com.backProyectoFinal.Entity.Dto.producto.ProductoEdit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface ProductoService {
    public ProductoDto crear(ProductoCreate dto);
    public ProductoDto edit(Long id, ProductoEdit dto);
    public ProductoDto buscaId(Long id);
    public Set<ProductoDto> traerTodos();
    public void eliminar(Long id);
    // Metodo para dar de baja/alta un producto
    public ProductoDto cambiarDisponibilidad(Long id);
    public ProductoDto aumentarStock(Long id, int cantidadAgregada);
    public ProductoDto disminuirStock(Long id, int cantidadVendida);
    public List<ProductoDto> traerPorCategoria(Long idCategoria);

}
