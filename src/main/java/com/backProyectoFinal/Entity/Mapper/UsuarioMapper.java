package com.backProyectoFinal.Entity.Mapper;

import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEditEmergencia;
import com.backProyectoFinal.Entity.Usuario;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioCreate;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioDto;

public abstract class UsuarioMapper {

    public static UsuarioDto toDto(Usuario u){
        return new UsuarioDto().builder()
            .id(u.getId())
            .nombre(u.getNombre())
            .apellido(u.getApellido())
            .celular(u.getCelular())
            .email(u.getEmail())
            .contrasenia(u.getContrasenia())
            .rol(u.getRol())
            .build();
    }
    public static Usuario toEntity (UsuarioCreate dto){
        return new Usuario().builder()
            .nombre(dto.getNombre())
            .apellido(dto.getApellido())
            .celular(dto.getCelular())
            .contrasenia(dto.getContrasenia())
            .email(dto.getEmail())
            .build();
    }

    public static UsuarioEditEmergencia toLoginDto (Usuario u){
        return new UsuarioEditEmergencia().builder()
                .email(u.getEmail())
                .contrasenia(u.getContrasenia())
                .build();
    }
}
