package com.iud.appsenado.controller;

import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.models.Proyecto;
import com.iud.appsenado.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @CrossOrigin
    @PostMapping(value = "/crearProyecto")
    public ProyectoDto guardarProyecto ( @RequestBody ProyectoDto proyectoDto ) {
        return proyectoService.guardarProyecto ( proyectoDto );
    }

    @CrossOrigin
    @PostMapping(value = "/actualizarProyecto/{proyectoId}")
    public ProyectoDto actualizarProyecto ( @RequestBody ProyectoDto proyectoDto ) {
        if (proyectoDto.getProyectoId ( ) != 0) {
            return proyectoService.guardarProyecto ( proyectoDto );

        }
        throw new RuntimeException ( "El id no existe" );


    }

    @CrossOrigin
    @DeleteMapping(value = "/eliminarProyecto/{proyectoId}")
    public void eliminarProyecto ( @PathVariable int proyectoId ) {
        proyectoService.eliminarProyecto ( proyectoId );

    }

    @CrossOrigin
    @GetMapping(value = "/obtenerProyectos")
    public Iterable < Proyecto > obtenerProyectos ( ) {
        return proyectoService.obtenerProyectos ( );

    }

    @CrossOrigin
    @GetMapping(value = "/obtenerProyectoPorId/{proyectoId}")
    public ProyectoDto obtenerProyectoPorId ( @PathVariable int proyectoId ) {
        return proyectoService.obtenerProyectoPorId ( proyectoId );
    }
}
