package com.backProyectoFinal.Repository;

import com.backProyectoFinal.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public Set<Producto> findByEliminadoFalse();

}
