package com.backProyectoFinal.Repository;

import com.backProyectoFinal.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public Set<Producto> findByEliminadoFalse();

    // @Query("SELECT p FROM Producto p WHERE p.categoria.id = :idCategoria")
    // List<Producto> findByCategoriaId(@Param("idCategoria") Long idCategoria);
    
    @Query(value = "SELECT * FROM producto WHERE categoria_id = :idCategoria", nativeQuery = true)
List<Producto> findByCategoriaId(@Param("idCategoria") Long idCategoria);


}
