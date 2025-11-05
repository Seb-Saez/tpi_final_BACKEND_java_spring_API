package com.backProyectoFinal.Service;

import com.backProyectoFinal.Entity.Dto.categoria.CategoriaCreate;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaDto;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaEdit;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaMostrar;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;

import java.util.Set;

public interface CategoriaService {
    //crear dto de la categoria
    public CategoriaDto crear(CategoriaCreate dto);

    //editar la categoria Dto
    public CategoriaDto edit(Long id, CategoriaEdit dto);

    //buscar categoriaDto
    public CategoriaDto buscaId(Long id);

    //traer todos los tipos de categorias Dto
    public Set<CategoriaDto> traerTodos();

    //eliminar por id
    public void eliminar(Long id);

    //método para agregar un producto a la categoria
    public void agregarProducto(Long idCategoria, Long idProducto);

    //método para eliminar un producto a la categoria
    public void eliminarProducto(Long idCategoria, Long idProducto);



}
