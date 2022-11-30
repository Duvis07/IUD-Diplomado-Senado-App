package com.iud.appsenado.controller;


import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Voto;
import com.iud.appsenado.interfaces.VotoServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoServiceDto votoServiceDto;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping
    public ResponseEntity < VotoDto > guardarVoto ( @Valid @RequestBody VotoDto votoDto ) {
        return new ResponseEntity <> ( votoServiceDto.crearVoto ( votoDto ) , HttpStatus.CREATED );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < Voto > obtenerVotos ( ) {
        return votoServiceDto.obtenerVotos ( );
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity < String > eliminarVotos ( @PathVariable Integer id ) {
        votoServiceDto.eliminarVoto ( id );
        return new ResponseEntity <> ( "El voto con id " + id + " fue correctamente eliminado" , HttpStatus.OK );

    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity < VotoDto > obtenerVotoPorId ( @PathVariable Integer id ) {
        return ResponseEntity.ok ( votoServiceDto.obtenerVotoPorId ( id ) );
    }



    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping(value = "/{id}")
    public ResponseEntity < VotoDto > actualizarUsuarios ( @Valid @RequestBody VotoDto votoDto , @PathVariable Integer id ) {
        VotoDto votoDtoResponse = votoServiceDto.actualizarVoto ( votoDto , id );
        return new ResponseEntity <> ( votoDtoResponse , HttpStatus.OK );
    }


}

