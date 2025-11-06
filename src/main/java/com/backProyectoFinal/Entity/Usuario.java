package com.backProyectoFinal.Entity;

import java.util.List;

import com.backProyectoFinal.Entity.Enum.Rol;

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

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Rol rol = Rol.USUARIO ;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "usuario_id")
    private List<Pedido> pedidos;


}
