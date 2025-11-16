package com.backProyectoFinal.Entity.Dto.pedido;

import java.lang.ProcessHandle.Info;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.backProyectoFinal.Entity.DetallePedido;
import com.backProyectoFinal.Entity.Dto.detallePedido.DetallePedidoDto;
import com.backProyectoFinal.Entity.Dto.infoEntrega.InfoEntregaDto;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {
    private Long id;
    private String fecha;
    private EstadoPedido estado;
    private double total;
    private List <DetallePedidoDto> detalles;
    private InfoEntregaDto infoEntrega;
}
