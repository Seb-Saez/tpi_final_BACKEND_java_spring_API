package com.backProyectoFinal.Entity;

import com.backProyectoFinal.Entity.Enum.FormaDePago;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

public class InfoEntrega extends Base{
 
    private String telefono;
    private String direccion;
    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;
    private String notaAdicional;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
