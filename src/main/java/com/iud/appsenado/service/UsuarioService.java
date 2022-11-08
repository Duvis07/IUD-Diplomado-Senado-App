package com.iud.appsenado.service;

import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.mappers.UsuarioMappers;
import com.iud.appsenado.models.Usuario;
import com.iud.appsenado.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMappers usuarioMappers;

    public UsuarioDto guardarUsuario ( UsuarioDto usuarioDto ) {
        Usuario usuario = usuarioMappers.usuarioDtoAUsuario ( usuarioDto );
        usuarioRepository.save ( usuario );
        return usuarioDto;


    }

    public Iterable < Usuario > obtenerUsuarios ( ) {
        return usuarioRepository.findAll ( );
    }

    public void eliminarUsuario ( int usuarioId ) {
        usuarioRepository.deleteById ( usuarioId );
    }

    public UsuarioDto obtenerUsuarioPorId ( int usuarioId ) {
        Usuario usuario = usuarioRepository.findById ( usuarioId
        ).get ( );
        UsuarioDto usuarioDto = usuarioMappers.usuarioAUsuarioDto ( usuario );
        return usuarioDto;
    }


}


