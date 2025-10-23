package com.backProyectoFinal.Service;

import java.util.Set;

import com.backProyectoFinal.Entity.Dto.usuario.UsuarioCreate;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioDto;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEdit;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEditEmergencia;


public interface UsuarioService{

    public UsuarioDto crear(UsuarioCreate dto);
    public UsuarioDto edit(Long id, UsuarioEdit dto);
    public UsuarioDto buscaId(Long id);
    public Set<UsuarioDto> traerTodos();
    public void eliminar(Long id);
    public UsuarioEditEmergencia verificarLogin(UsuarioEditEmergencia dto);
    /*
    public Set<Pedido> traerPedidos(Long id);
    */
}
