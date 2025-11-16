package com.backProyectoFinal.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.backProyectoFinal.Entity.InfoEntrega;
import com.backProyectoFinal.Entity.Dto.infoEntrega.InfoEntregaDto;

public interface InfoEntregaRepository extends JpaRepository<InfoEntrega,Long>{
    
   InfoEntrega findByPedidoId(Long idPedido);


}
