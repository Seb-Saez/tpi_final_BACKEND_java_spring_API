package com.backProyectoFinal.Repository;

import com.backProyectoFinal.Entity.Categoria;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public Set<Categoria> findByEliminadoFalse();

    boolean existsByNombre(String nombre);

}
