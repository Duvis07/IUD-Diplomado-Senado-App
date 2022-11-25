package com.iud.appsenado.controller;

import com.iud.appsenado.models.Rol;
import com.iud.appsenado.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;


    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @PostMapping
    public Rol crearSenador( @RequestBody Rol rol ) {
        return rolService.guardarRol ( rol );
    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @PutMapping(value = "/{id}")
    public Rol actualizarRoles(@RequestBody Rol rol) {
        return rolService.actualizarRol ( rol );
    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @DeleteMapping(value = "/{id}")
    public void eliminarRoles(@PathVariable Integer id) {
        rolService.eliminarRol ( id );
    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @GetMapping
    public Iterable< Rol > obtenerRoles() {
        return rolService.obtenerRoles();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Optional < Rol > obtenerRolPorId( @PathVariable Integer id) {
        return rolService.obtenerRolPorId ( id );
    }

}
