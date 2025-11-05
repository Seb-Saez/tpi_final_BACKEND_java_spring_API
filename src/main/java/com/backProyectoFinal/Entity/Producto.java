package com.backProyectoFinal.Entity;

import com.backProyectoFinal.Entity.Enum.EstadoProducto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Producto extends Base {

    private String nombre;
    private String descripcion;
    private String imagen;
    private  double precio;
    private int stock;
    private EstadoProducto estado;



}
