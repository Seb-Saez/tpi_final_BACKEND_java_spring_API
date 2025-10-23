package com.backProyectoFinal.Entity.Dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

// Dto especial para modificar el email y la contraseña, caso especial
public class UsuarioEditEmergencia {
    private String email;
    private String contrasenia;
}
