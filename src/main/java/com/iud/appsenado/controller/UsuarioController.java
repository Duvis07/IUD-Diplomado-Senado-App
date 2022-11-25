package com.iud.appsenado.controller;

import com.iud.appsenado.models.Usuario;
import com.iud.appsenado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @PostMapping
    public Usuario crearUsuario ( @RequestBody Usuario usuario ) {
        return usuarioService.guardarUsuario ( usuario );
    }

    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @PutMapping(value = "/{id}")
    public Usuario actualizarUsuario ( @RequestBody Usuario usuario ) {
        return usuarioService.actualizarUsuario ( usuario );
    }


    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @DeleteMapping(value = "/{id}")
    public void eliminarUsuario ( @PathVariable Integer id ) {
        usuarioService.eliminarUsuario ( id );
    }

    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @GetMapping
    public Iterable < Usuario > obtenerUsuarios ( ) {
        try {
            return usuarioService.obtenerUsuarios ( );
        } catch (Exception e) {
            System.out.printf ( "error " );
            return null;
        }
    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @GetMapping(value = "/{id}")
    public Optional < Usuario > obtenerUsuarioPorId ( @PathVariable Integer id ) {
        return usuarioService.obtenerUsuarioPorId ( id );
    }


}
