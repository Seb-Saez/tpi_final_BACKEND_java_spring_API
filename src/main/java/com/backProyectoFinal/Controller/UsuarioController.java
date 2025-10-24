package com.backProyectoFinal.Controller;

import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEditEmergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backProyectoFinal.Entity.Dto.usuario.UsuarioCreate;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioDto;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEdit;
import com.backProyectoFinal.Service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@CrossOrigin("*")
@RequestMapping("usuario")
public class UsuarioController {

@Autowired
UsuarioService usuarioService;


// Crear un usuario
@PostMapping("")
public ResponseEntity crear(@RequestBody UsuarioCreate dto) {
    
    try {
        return ResponseEntity.ok().body(usuarioService.crear(dto));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
    }

}

// Edatar un usuario por ID
@PutMapping("/{id}")
public ResponseEntity editar(@PathVariable Long id, @RequestBody UsuarioEdit dto) {
     try {
        return ResponseEntity.ok().body(usuarioService.edit(id,dto));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
    }
}

// Traer todos los usuarios
@GetMapping("")
public ResponseEntity traerTodos() {
        try {
        return ResponseEntity.ok().body(usuarioService.traerTodos());
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
    }
}

// Traer un usuario por ID
@GetMapping("/{id}")
public ResponseEntity buscarId(@PathVariable Long id) {
        try {
        return ResponseEntity.ok().body(usuarioService.buscaId(id));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
    }
}


// Eliminar un usuario por ID
@DeleteMapping("/{id}")
public ResponseEntity eliminar(@PathVariable Long id){
        try {
        usuarioService.eliminar(id);
        return ResponseEntity.ok().body("Usuario eliminado correctamente");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
    }
}


// LOGIN de un usuario
    @PostMapping("/login")
    public ResponseEntity verificarLogin(@RequestBody UsuarioEditEmergencia dto){
        try {
            UsuarioEditEmergencia usuario = usuarioService.verificarLogin(dto);

            if(usuario != null && dto.getContrasenia().equals(usuario.getContrasenia())){
                return ResponseEntity.ok("Usuario logeado correctamente");
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuario o contraseña incorrectos");

        } catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Ocurrio un error al verificar el login del usuario: " + e.getMessage());
        }
    }



}
