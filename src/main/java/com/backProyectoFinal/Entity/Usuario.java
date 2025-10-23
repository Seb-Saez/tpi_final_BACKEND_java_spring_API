package com.backProyectoFinal.Entity;

import com.backProyectoFinal.Entity.Enum.Rol;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario extends Base{

    private String nombre;
    private String apellido;
    private String email;
    private Long celular;
    private String contrasenia;

    @Builder.Default
    private Rol rol = Rol.USUARIO ;

}
