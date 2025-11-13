package com.backProyectoFinal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backProyectoFinal.Entity.Dto.pedido.PedidoCreate;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoEdit;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;
import com.backProyectoFinal.Service.PedidoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;




@RestController
@CrossOrigin("*")
@RequestMapping("/pedidos")

public class PedidoController {
@Autowired
PedidoService pedidoService;

@PostMapping("/crear/{idCliente}")
public ResponseEntity crear(@PathVariable Long idCliente, @RequestBody PedidoCreate dto) {
   try {
        return ResponseEntity.ok().body(pedidoService.crear(idCliente, dto));
   } catch (Exception e) {
        return ResponseEntity.badRequest().body("No se pudo crer el pedido");
   }
}

@PostMapping("/{id}")
public ResponseEntity editar(@PathVariable Long id, @RequestBody PedidoEdit dto) {
    try {
        return ResponseEntity.ok().body(pedidoService.edit(id, dto));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un problema: No se pudo editar el pedido");
    }
}

@GetMapping("")
public ResponseEntity traerTodos() {
    try {
        return ResponseEntity.ok().body(pedidoService.traerTodos());
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un problema: No se pudo traer los pedidos.");
    }
}

@GetMapping("/estado")
public ResponseEntity traerPorEstado(@RequestParam EstadoPedido estado) {
    try {
        return ResponseEntity.ok().body(pedidoService.buscarPorEstado(estado));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un problema: No se pudo traer los pedidos: "+estado);
    }
}

@GetMapping("/{id}")
public ResponseEntity buscaId(@PathVariable Long id) {
      try {
        return ResponseEntity.ok().body(pedidoService.buscaId(id));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un problema: No se pudo traer el pedido con id: " + id);
    }
}

@DeleteMapping("/{id}")
public ResponseEntity eliminar(@PathVariable Long id){
      try {
        pedidoService.eliminar(id);
        return ResponseEntity.ok().body("Pedido eliminado correctamente");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un problema: No se pudo eliminar el pedido con id: " + id);
    }
}

@PatchMapping("/{id}/estado")
public ResponseEntity cambiarEstado(@PathVariable Long id, @RequestParam EstadoPedido estado){
      try {
        return ResponseEntity.ok().body(pedidoService.cambiarEstado(id, estado));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Ocurrio un problema: No se pudo modificar el estado del pedido con id: " + id);
    }
}

}
