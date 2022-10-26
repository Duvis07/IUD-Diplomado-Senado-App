package com.iud.appsenado.controller;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.service.SenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SenadorController {

    @Autowired
    private SenadorService senadorService;


    @CrossOrigin
    @PostMapping(value = "/crearSenador")
    public SenadorDto crearSenador(@RequestBody SenadorDto senadorDto) {
      return senadorService.guardarSenador(senadorDto);
    }

    @CrossOrigin
    @PostMapping(value = "/actualizarSenador/{senadorId}")
    public SenadorDto actualizarSenador(@RequestBody SenadorDto senadorDto) {
        if (senadorDto.getSenadorId() != 0) {
            return senadorService.guardarSenador(senadorDto);
        }
        throw new RuntimeException("El id no existe");
    }

    @CrossOrigin
    @DeleteMapping(value = "/eliminarSenador/{senadorId}")
    public void eliminarSenador(@PathVariable int senadorId) {
        senadorService.eliminarSenador(senadorId);
    }

    @CrossOrigin
    @GetMapping(value = "/obtenerSenadores")
    public Iterable< Senador > obtenerSenadores() {
        return senadorService.obtenerSenadores();
    }

    @CrossOrigin
    @GetMapping(value = "/obtenerSenadorPorId/{senadorId}")
    public SenadorDto obtenerSenadorPorId(@PathVariable int senadorId) {
        return senadorService.obtenerSenadorPorId(senadorId);
    }


}
