package com.backProyectoFinal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backProyectoFinal.Entity.Pedido;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    public List<Pedido> findByEliminadoFalse();
    public List<Pedido> findByEstado(EstadoPedido estado);
}
