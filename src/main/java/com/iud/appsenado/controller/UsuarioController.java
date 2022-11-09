package com.iud.appsenado.controller;

import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.models.Usuario;
import com.iud.appsenado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin
    @PostMapping
    public UsuarioDto crearUsuario ( @RequestBody UsuarioDto usuarioDto ) {
        return usuarioService.guardarUsuario ( usuarioDto );
    }

    @CrossOrigin
    @PutMapping(value = "/{usuarioId}")
    public UsuarioDto actualizarUsuario ( @RequestBody UsuarioDto usuarioDto ) {
        if (usuarioDto.getUsuarioId ( ) != 0) {
            return usuarioService.guardarUsuario ( usuarioDto );
        }
        throw new RuntimeException ( "El id no existe" );
    }


    @CrossOrigin
    @DeleteMapping(value = "/{usuarioId}")
    public void eliminarUsuario ( @PathVariable int usuarioId ) {
        usuarioService.eliminarUsuario ( usuarioId );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < Usuario > obtenerUsuarios ( ) {
        return usuarioService.obtenerUsuarios ( );
    }

    @CrossOrigin
    @GetMapping(value = "/{usuarioId}")
    public UsuarioDto obtenerUsuarioPorId ( @PathVariable int usuarioId ) {
        return usuarioService.obtenerUsuarioPorId ( usuarioId );
    }


}
