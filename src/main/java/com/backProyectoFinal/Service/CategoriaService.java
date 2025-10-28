package com.backProyectoFinal.Service;

import com.backProyectoFinal.Entity.Dto.categoria.CategoriaCreate;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaDto;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaEdit;

import java.util.Set;

public interface CategoriaService {
    public CategoriaDto crear(CategoriaCreate dto);
    public CategoriaDto edit(Long id, CategoriaEdit dto);
    public CategoriaDto buscaId(Long id);
    public Set<CategoriaDto> traerTodos();
    public void eliminar(Long id);


}
