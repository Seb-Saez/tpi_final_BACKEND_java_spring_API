package com.backProyectoFinal.Entity.Dto.infoEntrega;

import com.backProyectoFinal.Entity.Enum.FormaDePago;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoEntregaCreate {
    private String telefono;
    private String direccion;
    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;
    private String notaAdicional;
}
