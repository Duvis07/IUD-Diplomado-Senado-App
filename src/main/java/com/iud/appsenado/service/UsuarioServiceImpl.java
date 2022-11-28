package com.iud.appsenado.service;

import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.interfaces.UsuarioServiceDto;
import com.iud.appsenado.mappers.UsuarioMappers;
import com.iud.appsenado.models.Usuario;
import com.iud.appsenado.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;


@Service
public class UsuarioServiceImpl implements UsuarioServiceDto {

    @Autowired
    private UsuarioMappers usuarioMappers;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UsuarioDto crearUsuario ( UsuarioDto usuarioDto ) {

        Usuario usuario = usuarioMappers.mapearEntidad ( usuarioDto );
        if (usuarioDto.getNombre().length() <= 3) {
            throw new ResourceAccessException ( "El nombre del usuario no puede ser menor a 3 caracteres" );
        }
        Usuario nuevoUsuario = usuarioRepository.save ( usuario );

        UsuarioDto nuevoUsuarioResponse = usuarioMappers.mapearDTO ( nuevoUsuario );

        return nuevoUsuarioResponse;

    }

    @Override
    public UsuarioDto actualizarUsuario ( UsuarioDto usuarioDto , Integer id ) {

        Usuario usuario = usuarioRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el usuario con id " + id ) );

        usuario.setNombre ( usuarioDto.getNombre ( ) );
        usuario.setEmail ( usuarioDto.getEmail ( ) );
        usuario.setUsername ( usuarioDto.getUsername ( ) );
        usuario.setPassword ( usuarioDto.getPassword ( ) );

        Usuario usuarioActualizado = usuarioRepository.save ( usuario );

        return usuarioMappers.mapearDTO ( usuarioActualizado );

    }

    @Override
    public Iterable < Usuario > obtenerUsuarios ( ) {
        return usuarioRepository.findAll ( );
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId ( Integer id ) {
        Usuario usuario = usuarioRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el usuario con id " + id ) );
        return usuarioMappers.mapearDTO ( usuario );
    }

    @Override
    public void eliminarUsuario ( Integer id ) {
        Usuario usuario = usuarioRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el usuario con id " + id ) );
        usuarioRepository.delete ( usuario );

    }

}

