package com.backProyectoFinal.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;

import java.util.List;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria extends Base {

    private String nombre;
    private String imagen;
    private String descripcion;

    @OneToMany//(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private List<Producto> productos;
}
