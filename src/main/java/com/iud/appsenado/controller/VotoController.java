package com.iud.appsenado.controller;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Voto;
import com.iud.appsenado.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;


    @CrossOrigin
    @PostMapping
    public VotoDto crearVoto ( @RequestBody VotoDto votoDto ) {
        return votoService.guardarVoto ( votoDto );
    }


    @CrossOrigin
    @PutMapping(value = "/{votoId}")
    public VotoDto actualizarVoto ( @RequestBody VotoDto votoDto ) {
        if (votoDto.getVotoId ( ) != 0) {
            return votoService.guardarVoto ( votoDto );
        }
        throw new RuntimeException ( "El id no existe" );
    }


    @CrossOrigin
    @DeleteMapping(value = "/{votoId}")
    public void eliminarVoto ( @PathVariable int votoId ) {
        votoService.eliminarVoto ( votoId );
    }


    @CrossOrigin
    @GetMapping
    public Iterable < Voto > obtenerVotos ( ) {
        return votoService.obtenerVotos ( );
    }


    @CrossOrigin
    @GetMapping(value = "/{votoId}")
    public VotoDto obtenerVotoPorId ( @PathVariable int votoId ) {
        return votoService.obtenerVotoPorId ( votoId );
    }


}
