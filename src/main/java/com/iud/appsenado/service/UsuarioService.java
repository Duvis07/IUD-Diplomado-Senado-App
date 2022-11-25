package com.iud.appsenado.service;


import com.iud.appsenado.models.Usuario;
import com.iud.appsenado.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario guardarUsuario ( Usuario usuario ) {
      return usuarioRepository.save ( usuario );

    }

    public Iterable < Usuario > obtenerUsuarios ( ) {
        return usuarioRepository.findAll ( );
    }

    public void eliminarUsuario ( Integer id ) {
        usuarioRepository.deleteById ( id );
    }

    public Optional < Usuario > obtenerUsuarioPorId ( Integer id ) {
        return usuarioRepository.findById ( id);
    }

    public Usuario actualizarUsuario ( Usuario usuario ) {
        return usuarioRepository.save ( usuario );
    }


}


