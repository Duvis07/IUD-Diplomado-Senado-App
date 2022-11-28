package com.iud.appsenado.controller;


import com.iud.appsenado.dto.RolDto;
import com.iud.appsenado.models.Rol;
import com.iud.appsenado.interfaces.RolServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolServiceDto rolServiceDto;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity < RolDto > guardarRol ( @Valid @RequestBody RolDto rolDto ) {
        return new ResponseEntity <> ( rolServiceDto.crearRol ( rolDto  ) , HttpStatus.CREATED );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < Rol > obtenerRoles ( ) {
        return rolServiceDto.obtenerRoles ( );
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity < String > eliminarRoles ( @PathVariable Integer id ) {
        rolServiceDto.eliminarRol ( id );
        return new ResponseEntity <> ( "El rol con id " + id + " fue correctamente eliminado" , HttpStatus.OK );

    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity < RolDto > obtenerRolPorId ( @PathVariable Integer id ) {
        return ResponseEntity.ok ( rolServiceDto.obtenerRolPorId ( id ) );
    }


    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity < RolDto > actualizarRol ( @Valid @RequestBody RolDto rolDto, @PathVariable Integer id ) {
        RolDto rolResponse = rolServiceDto.actualizarRol ( rolDto , id );
        return new ResponseEntity <> ( rolResponse , HttpStatus.OK );
    }


}
