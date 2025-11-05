package com.backProyectoFinal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Builder
public class DetallePedido extends Base{

    private int cantidad;
    private double subtotal;

    @ManyToOne
    @JoinColumn( name = "producto_id")
    private Producto producto;
}
