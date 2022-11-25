package com.iud.appsenado.controller;


import com.iud.appsenado.models.Proyecto;
import com.iud.appsenado.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @CrossOrigin
    @PostMapping
    @PreAuthorize( "hasRole('ADMIN')" )
    public Proyecto guardarProyecto ( @RequestBody Proyecto proyecto ) {
        return proyectoService.guardarProyecto ( proyecto );
    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @GetMapping
    public Iterable < Proyecto > obtenerProyectos ( ) {
        return proyectoService.obtenerProyectos ( );

    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @DeleteMapping("/{id}")
    public void eliminarProyecto ( @PathVariable Integer id ) {
        proyectoService.eliminarProyecto ( id );

    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @GetMapping("/{id}")
    public Optional < Proyecto > obtenerProyectoPorId ( @PathVariable Integer id ) {
        return proyectoService.obtenerProyectoPorId ( id );
    }

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @PutMapping(value = "/{id}")
    public Proyecto actualizarProyecto ( @RequestBody Proyecto proyecto ) {
        return proyectoService.actualizarProyecto ( proyecto );


    }



}
