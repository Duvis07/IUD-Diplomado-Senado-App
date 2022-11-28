package com.iud.appsenado.controller;


import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.models.Proyecto;
import com.iud.appsenado.interfaces.ProyectoServiceDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoServiceDto proyectoServiceDto;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping
    public ResponseEntity < ProyectoDto > guardarProyecto ( @Valid @RequestBody ProyectoDto proyectoDto ) {
        return new ResponseEntity <> ( proyectoServiceDto.crearProyecto ( proyectoDto ) , HttpStatus.CREATED );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < Proyecto > obtenerProyectos ( ) {
        return proyectoServiceDto.obtenerProyectos ( );
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity < String > eliminarProyecto ( @PathVariable Integer id ) {
        proyectoServiceDto.eliminarProyecto ( id );
        return new ResponseEntity <> ( "El proyecto con id " + id + " fue correctamente eliminado" , HttpStatus.OK );

    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity < ProyectoDto > obtenerProyectoPorId ( @PathVariable Integer id ) {
        return ResponseEntity.ok ( proyectoServiceDto.obtenerProyectoPorId ( id ) );
    }



    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping(value = "/{id}")
    public ResponseEntity < ProyectoDto > actualizarProyecto ( @Valid @RequestBody ProyectoDto proyectoDto , @PathVariable Integer id ) {
        ProyectoDto proyectoDtoResponse = proyectoServiceDto.actualizarProyecto ( proyectoDto , id );
        return new ResponseEntity <> ( proyectoDtoResponse , HttpStatus.OK );
    }

}




