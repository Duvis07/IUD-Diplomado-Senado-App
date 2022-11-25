package com.iud.appsenado.controller;

import com.iud.appsenado.models.Voto;
import com.iud.appsenado.service.VotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    private static final Logger log =
            LoggerFactory.getLogger(VotoController.class);

    @CrossOrigin
    @PostMapping
    public Voto crearVoto ( @RequestBody Voto voto ) {
        return votoService.guardarVoto ( voto );
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public Voto actualizarVoto ( @RequestBody Voto voto ) {
        return votoService.actualizarVoto ( voto );
    }


    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void eliminarVoto ( @PathVariable Integer id ) {
        votoService.eliminarVoto ( id );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < Voto > obtenerVotos ( ) {

        try {
            return votoService.obtenerVotos ( );
        } catch (Exception e) {
            log.error("Error al obtener votos", e);
            return null;
        }

    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Optional < Voto > obtenerVotoPorId ( @PathVariable Integer id ) {
        return votoService.obtenerVotoPorId ( id );
    }


}

