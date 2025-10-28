package com.backProyectoFinal.Controller;

import com.backProyectoFinal.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;


    //  CRUD Categoria
// --Leer categoria


// --Crear categoria


// --Actualizar categoria


// --Delete categoria



}
