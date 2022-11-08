package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.RolDto;
import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.models.Rol;
import com.iud.appsenado.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMappers {

    public Usuario usuarioDtoAUsuario ( UsuarioDto usuarioDto ) {
        Usuario usuario = new Usuario ( );
        usuario.setUsuarioId ( usuarioDto.getUsuarioId ( ) );
        usuario.setNombre ( usuarioDto.getNombre ( ) );
        usuario.setCorreo ( usuarioDto.getCorreo ( ) );
        usuario.setContrasena ( usuarioDto.getContrasena ( ) );

        Rol rol = new Rol ( );
        rol.setRolId ( usuarioDto.getRol ( ).getRolId ( ) );
        usuario.setRol ( rol );

        return usuario;
    }

    public UsuarioDto usuarioAUsuarioDto ( Usuario usuario ) {
        UsuarioDto usuarioDto = new UsuarioDto ( );
        usuarioDto.setUsuarioId ( usuario.getUsuarioId ( ) );
        usuarioDto.setNombre ( usuario.getNombre ( ) );
        usuarioDto.setCorreo ( usuario.getCorreo ( ) );
        usuarioDto.setContrasena ( usuario.getContrasena ( ) );

        RolDto rolDto = new RolDto ( );
        rolDto.setRolId ( usuario.getRol ( ).getRolId ( ) );
        usuarioDto.setRol ( rolDto );

        return usuarioDto;
    }


}
