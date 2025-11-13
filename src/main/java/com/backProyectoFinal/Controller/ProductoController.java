package com.backProyectoFinal.Controller;

import com.backProyectoFinal.Entity.Dto.producto.ProductoCreate;
import com.backProyectoFinal.Entity.Dto.producto.ProductoEdit;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioCreate;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEdit;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEditEmergencia;
import com.backProyectoFinal.Service.ProductoService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/productos")
@CrossOrigin("*")
@RestController
public class ProductoController {

    //inyecta el servicio para interactuar con la base de datos
@Autowired
    ProductoService productoService;

    // crear producto
    @PostMapping("/crear")
    public ResponseEntity crear(@RequestParam Long idCategoria, @RequestBody ProductoCreate dto) {

        try {
            return ResponseEntity.ok().body(productoService.crear(idCategoria,dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }

    }

    // Editar un producto por ID
    @PutMapping("/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody ProductoEdit dto) {
        try {
            return ResponseEntity.ok().body(productoService.edit(id,dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }
    }

    // Traer todos los productos
    @GetMapping("")
    public ResponseEntity traerTodos() {
        try {
            return ResponseEntity.ok().body(productoService.traerTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }
    }

    // Traer producto por ID
    @GetMapping("/{id}")
    public ResponseEntity buscarId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(productoService.buscaId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }
    }


    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        try {
            productoService.eliminar(id);
            return ResponseEntity.ok().body("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }
    }

      @PatchMapping("/{id}")
    public ResponseEntity cambiarDisponibilidad(@PathVariable Long id) {
        try {
            
            return ResponseEntity.ok().body(productoService.cambiarDisponibilidad(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/disminuirStock")
    // para probar /productos/1/disminuirStock?cantidad=2
public ResponseEntity disminuirStock(@PathVariable Long id, @RequestParam int cantidad) {
    try {
        return ResponseEntity.ok(productoService.disminuirStock(id, cantidad));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

@PatchMapping("/{id}/aumentarStock")
    // para probar en postman /productos/1/aumentarStock?cantidad=10
public ResponseEntity aumentarStock(@PathVariable Long id, @RequestParam int cantidad) {
    try {
        return ResponseEntity.ok(productoService.aumentarStock(id, cantidad));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}



}
