package com.iud.appsenado.controller;

import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.models.Usuario;
import com.iud.appsenado.interfaces.UsuarioServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceDto usuarioServiceDto;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity < UsuarioDto > guardarUsuario ( @Valid @RequestBody UsuarioDto usuarioDto ) {
        return new ResponseEntity <> ( usuarioServiceDto.crearUsuario ( usuarioDto ) , HttpStatus.CREATED );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < Usuario > obtenerUsuarios ( ) {
        return usuarioServiceDto.obtenerUsuarios ( );
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity < String > eliminarUsuarios ( @PathVariable Integer id ) {
        usuarioServiceDto.eliminarUsuario ( id );
        return new ResponseEntity <> ( "El usuario con id " + id + " fue correctamente eliminado" , HttpStatus.OK );

    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity < UsuarioDto > obtenerUsuarioPorId ( @PathVariable Integer id ) {
        return ResponseEntity.ok ( usuarioServiceDto.obtenerUsuarioPorId ( id ) );
    }



    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity < UsuarioDto > actualizarUsuarios ( @Valid @RequestBody UsuarioDto usuarioDto , @PathVariable Integer id ) {
        UsuarioDto usuarioDtoResponse = usuarioServiceDto.actualizarUsuario ( usuarioDto , id );
        return new ResponseEntity <> ( usuarioDtoResponse , HttpStatus.OK );
    }


}
