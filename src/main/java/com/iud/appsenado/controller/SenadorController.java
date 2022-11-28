package com.iud.appsenado.controller;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.interfaces.SenadorServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/senadores")
public class SenadorController {

    @Autowired
    private SenadorServiceDto senadorServiceDto;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity < SenadorDto > guardarSenador ( @Valid @RequestBody SenadorDto senadorDTO ) {
        return new ResponseEntity <> ( senadorServiceDto.crearSenador ( senadorDTO ) , HttpStatus.CREATED );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < Senador > obtenerSenadores ( ) {
        return senadorServiceDto.obtenerSenadores ( );
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity < String > eliminarSenadores ( @PathVariable Integer id ) {
        senadorServiceDto.eliminarSenador ( id );
        return new ResponseEntity <> ( "El senador con id " + id + " fue correctamente eliminado" , HttpStatus.OK );

    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity < SenadorDto > obtenerSenadorPorId ( @PathVariable Integer id ) {
        return ResponseEntity.ok ( senadorServiceDto.obtenerSenadorPorId ( id ) );
    }


    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity < SenadorDto > actualizarSenador ( @Valid @RequestBody SenadorDto senadorDto , @PathVariable Integer id ) {
        SenadorDto senadorDtoResponse = senadorServiceDto.actualizarSenador ( senadorDto , id );
        return new ResponseEntity <> ( senadorDtoResponse , HttpStatus.OK );
    }

}
