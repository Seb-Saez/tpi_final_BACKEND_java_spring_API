package com.backProyectoFinal.Impl;

import java.util.Set;
import java.util.stream.Collectors;

import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEditEmergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backProyectoFinal.Entity.Usuario;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioCreate;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioDto;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEdit;
import com.backProyectoFinal.Entity.Mapper.UsuarioMapper;
import com.backProyectoFinal.Repository.UsuarioRepository;
import com.backProyectoFinal.Service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;


    // metodo para crear un usuario
    @Override
    public UsuarioDto crear(UsuarioCreate dto) {
    Usuario usuario = UsuarioMapper.toEntity(dto);
    usuarioRepository.save(usuario);
    return UsuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto edit(Long id, UsuarioEdit dto) {
     Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(()->new NullPointerException("Usaurio no encontrado con el id: " + id));
    usuario.setNombre(dto.getNombre());
    usuario.setApellido(dto.getApellido());
    usuario.setCelular(dto.getCelular());

    usuarioRepository.save(usuario);
    return UsuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto buscaId(Long id) {
       return UsuarioMapper.toDto(usuarioRepository.findById(id).orElseThrow(()->new NullPointerException()));
    }

    @Override
    public Set<UsuarioDto> traerTodos() {
        return usuarioRepository.findAll().stream()
            .map(UsuarioMapper::toDto)
            .collect(Collectors.toSet());
            

    }

    @Override
    public void eliminar(Long id) {
        Usuario u = usuarioRepository.findById(id)
            .orElseThrow(()->new NullPointerException("Usuario no encontrado..."));
        u.setEliminado(true);
        usuarioRepository.save(u);
    }

    @Override
    public UsuarioEditEmergencia verificarLogin(UsuarioEditEmergencia dto) {
        Usuario u = usuarioRepository.findByEmail(dto.getEmail());
        if(u != null){
            return UsuarioMapper.toLoginDto(u);
        } else{
            throw new RuntimeException("No se encontro un usuario con ese Email");
        }

    }
/*    En este endpoint hacemos la validacion de las contraseñas en el if
    @Override
    public UsuarioEditEmergencia verificarLogin(UsuarioEditEmergencia dto) {
        Usuario u = usuarioRepository.findByEmail(dto.getEmail());
        if(u != null && u.getContrasenia() == dto.getContrasenia()){
            return UsuarioMapper.toLoginDto(u);
        } else{
            throw new RuntimeException("No se encontro un usuario con ese Email");
        }

    }
*/

}
