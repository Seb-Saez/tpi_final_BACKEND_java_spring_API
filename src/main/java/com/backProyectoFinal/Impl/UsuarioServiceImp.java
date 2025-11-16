package com.backProyectoFinal.Impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEditEmergencia;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioTransferenciaLogin;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.backProyectoFinal.Entity.Usuario;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoDto;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioCreate;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioDto;
import com.backProyectoFinal.Entity.Dto.usuario.UsuarioEdit;
import com.backProyectoFinal.Entity.Mapper.PedidoMapper;
import com.backProyectoFinal.Entity.Mapper.UsuarioMapper;
import com.backProyectoFinal.Repository.UsuarioRepository;
import com.backProyectoFinal.Service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
      private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    // metodo para crear un usuario
    @Override
    public UsuarioDto crear(UsuarioCreate dto) {
    // Validamos que no exista un email
    if(usuarioRepository.findByEmail(dto.getEmail())!=null){
        throw new RuntimeException("Ya existe un usuario registrado con ese email");
    }
    Usuario usuario = UsuarioMapper.toEntity(dto);
    usuario.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
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
    public UsuarioTransferenciaLogin verificarLogin(UsuarioEditEmergencia dto) {

        Usuario u = usuarioRepository.findByEmail(dto.getEmail());

            if(u == null){
               throw new RuntimeException("No se encontro un usuario con ese Email"); 
            }
             else if(u != null && !(passwordEncoder.matches(dto.getContrasenia(), u.getContrasenia()))){
                throw new RuntimeException("La contraseña no coincide"); 
            }
        else{
            return UsuarioMapper.enviarFront(u);
        }

    }


    @Override
    public List<PedidoDto> traerPedidos(String email) {
        Usuario u = usuarioRepository.findByEmail(email);
        return u.getPedidos().stream()
            .map(PedidoMapper::toDto)
            .toList();
    } 

      @Override
    public List<PedidoDto> traerPedidosPorEstado(String email, EstadoPedido estado) {
        Usuario u = usuarioRepository.findByEmail(email);
        return u.getPedidos().stream()
            .filter(pedido-> pedido.getEstado().equals(estado))
            .map(PedidoMapper::toDto)
            .collect(Collectors.toList());
    } 




}
