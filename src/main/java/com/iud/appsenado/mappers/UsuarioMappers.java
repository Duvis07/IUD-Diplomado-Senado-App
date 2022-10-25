package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.models.Usuario;
import org.springframework.beans.BeanUtils;

public class UsuarioMappers {

    public Usuario usuarioDtoAUsuario( UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario ();
        usuario.setUsuarioId (usuarioDto.getUsuarioId ());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setCorreo(usuarioDto.getCorreo());
        usuario.setContrasena(usuarioDto.getContrasena());
        BeanUtils.copyProperties ( usuarioDto , usuario );

        return usuario;
    }

    public UsuarioDto usuarioAUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setUsuarioId (usuario.getUsuarioId ());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setCorreo(usuario.getCorreo());
        usuarioDto.setContrasena(usuario.getContrasena());
        BeanUtils.copyProperties ( usuario , usuarioDto );

        return usuarioDto;
    }


}
