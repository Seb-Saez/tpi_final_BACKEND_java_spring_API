package com.backProyectoFinal.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria extends Base {

    private String nombre;
    @Column(length = 1000)
    private String imagen;
    private String descripcion;

    @OneToMany//(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Set<Producto> productos = new HashSet<>();

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }
    public void eliminarProducto(Producto producto){
        this.productos.remove(producto);
    }
}
