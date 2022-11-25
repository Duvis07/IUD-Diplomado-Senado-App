package com.iud.appsenado.controller;

import com.iud.appsenado.models.Senador;
import com.iud.appsenado.service.SenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/senadores")
public class SenadorController {

    @Autowired
    private SenadorService senadorService;


    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @PostMapping
    public Senador crearSenador(@RequestBody Senador senador)
    {
      return senadorService.guardarSenador(senador);
    }

    @CrossOrigin
    @GetMapping
    public Iterable< Senador > obtenerSenadores() {
        return senadorService.obtenerSenadores();
    }

    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @DeleteMapping(value = "/{id}")
    public void eliminarSenador(@PathVariable Integer id)
    {
        senadorService.eliminarSenador(id);
    }

    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @GetMapping(value = "/{id}")
    public Optional < Senador > obtenerSenadorPorId( @PathVariable Integer id) {
        return senadorService.obtenerSenadorPorId(id);
    }
    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @PutMapping(value = "/{id}")
    public Senador actualizarSenador(@RequestBody Senador senador)
    {
        return senadorService.actualizarSenador(senador);
    }







}
