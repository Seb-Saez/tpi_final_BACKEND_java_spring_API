package com.backProyectoFinal.Entity.Dto.usuario;

import com.backProyectoFinal.Entity.Enum.Rol;

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

public class UsuarioCreate {

    private String nombre;
    private String apellido;
    private String email;
    private Long celular;
    private String contrasenia;
}
/*
 {
    "nombre":"alberto",
    "apellido":"Cortez",
    "email":"alberto@gmail",
    "celular":12312313 ,
    "contrasenia":"1234"

}
 */