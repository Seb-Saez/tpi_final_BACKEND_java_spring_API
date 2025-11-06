package com.backProyectoFinal.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.backProyectoFinal.Entity.Enum.EstadoPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Pedido extends Base{

    
    private LocalDateTime ahora = LocalDateTime.now();
    
    String fecha = ahora.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EstadoPedido estado = EstadoPedido.PENDIENTE;
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn( name = "pedido_id")
    private List<DetallePedido> detalles = new ArrayList<>();
}
