package com.iud.appsenado.controller;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.service.SenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/senadores")
public class SenadorController {

    @Autowired
    private SenadorService senadorService;


    @CrossOrigin
    @PostMapping
    public SenadorDto crearSenador(@RequestBody SenadorDto senadorDto) {
      return senadorService.guardarSenador(senadorDto);
    }

    @CrossOrigin
    @PutMapping(value = "/{senadorId}")
    public SenadorDto actualizarSenador(@RequestBody SenadorDto senadorDto) {
        if (senadorDto.getSenadorId() != 0) {
            return senadorService.guardarSenador(senadorDto);
        }
        throw new RuntimeException("El id no existe");
    }

    @CrossOrigin
    @DeleteMapping(value = "/{senadorId}")
    public void eliminarSenador(@PathVariable int senadorId) {
        senadorService.eliminarSenador(senadorId);
    }

    @CrossOrigin
    @GetMapping
    public Iterable< Senador > obtenerSenadores() {
        return senadorService.obtenerSenadores();
    }

    @CrossOrigin
    @GetMapping(value = "/{senadorId}")
    public SenadorDto obtenerSenadorPorId(@PathVariable int senadorId) {
        return senadorService.obtenerSenadorPorId(senadorId);
    }


}
