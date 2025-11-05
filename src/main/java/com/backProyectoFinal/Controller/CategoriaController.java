package com.backProyectoFinal.Controller;

import com.backProyectoFinal.Entity.Dto.categoria.CategoriaCreate;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaEdit;
import com.backProyectoFinal.Service.CategoriaService;
import com.backProyectoFinal.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;


    //  CRUD Categoria

//CREAR CATEGORIA
@PostMapping("")
    public ResponseEntity crear(@RequestBody CategoriaCreate dto){

    try{
        return ResponseEntity.ok().body(categoriaService.crear(dto));
    }catch(Exception e){
        return ResponseEntity.badRequest().body("Ocurrió un error:"+ e.getMessage());
    }
}
//EDITAR CATEGORIA
@PutMapping("/{id}")
public ResponseEntity editar(@PathVariable Long id, @RequestBody CategoriaEdit dto){
    try{
        return ResponseEntity.ok().body(categoriaService.edit(id,dto));
    }catch(Exception e){
        return ResponseEntity.badRequest().body("Ocurrió un error:"+e.getMessage());
    }
}
//TRAER TODOS LAS CATEGORIAS
@GetMapping("")
public ResponseEntity traerTodos(){
    try{
        return  ResponseEntity.ok(categoriaService.traerTodos());
    }catch (Exception e){
        return ResponseEntity.badRequest().body("Ocurrió un error:"+e.getMessage());
    }
}
//BUSCAR LOS CATEGORIA POR ID
@GetMapping("/{id}")
public ResponseEntity buscarId(@PathVariable Long id){
    try{
        return  ResponseEntity.ok().body(categoriaService.buscaId(id));
    }catch(Exception e){
        return ResponseEntity.badRequest().body("Ocurrió un error:"+e.getMessage());
    }
}

//ELIMINAR CATEGORIA POR ID
@DeleteMapping("/{id}")
public ResponseEntity eliminar(@PathVariable Long id){
    try{
        categoriaService.eliminar(id);
        return ResponseEntity.ok().body(" Categoria eliminada correctamente");
    }catch(Exception e){
        return ResponseEntity.badRequest().body("Ocurrió un error"+e.getMessage());
    }
}
//AGREGAR Producto dentro de la categoria
@PostMapping("/agregarProducto")
public  ResponseEntity agregarProducto(@RequestParam Long idCategoria, @RequestParam Long idProducto){

    try{
        categoriaService.agregarProducto(idCategoria, idProducto);
        return  ResponseEntity.ok().body("Producto agregado correctamente");
    }catch(Exception e){
        return  ResponseEntity.badRequest().body("Ocurrió un error:"+ e.getMessage());
    }
}
//ELIMINAR Producto dentro de la categoria
@PostMapping("/eliminarProducto")
public ResponseEntity eliminarProducto(@RequestParam Long idCategoria, @RequestParam Long idProducto){

    try{
        categoriaService.eliminarProducto(idCategoria,idProducto);
        return ResponseEntity.ok().body("Producto eliminado correctamente");
    }catch(Exception e){
        return ResponseEntity.badRequest().body("Ocurrió un error"+ e.getMessage());
    }
}

}
