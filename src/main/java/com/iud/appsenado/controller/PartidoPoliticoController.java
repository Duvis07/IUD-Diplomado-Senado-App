package com.iud.appsenado.controller;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.service.PartidoPoliticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartidoPoliticoController {

    @Autowired
    private PartidoPoliticoService partidoPoliticoService;

    @CrossOrigin
    @PostMapping(value = "/partidoPolitico")
    public PartidoPoliticoDto guardarPartidoPolitico ( @RequestBody PartidoPoliticoDto partidoPoliticoDto ) {
        return partidoPoliticoService.guardarPartidoPolitico ( partidoPoliticoDto );
    }

    @CrossOrigin
    @GetMapping(value = "/obtenerPartidosPoliticos")
    public Iterable < PartidoPolitico > obtenerPartidosPoliticos ( ) {
        return partidoPoliticoService.obtenerPartidosPoliticos ( );

    }

    @CrossOrigin
    @DeleteMapping(value = "/eliminarPartidoPolitico/{partidoId}")
    public void eliminarPartidoPolitico ( @PathVariable int partidoId ) {
        partidoPoliticoService.eliminarPartidoPolitico ( partidoId );


    }

    @CrossOrigin
    @GetMapping(value = "/obtenerPartidoPoliticoPorId/{partidoId}")
    public PartidoPoliticoDto obtenerPartidoPoliticoPorId ( @PathVariable int partidoId ) {
        return partidoPoliticoService.obtenerPartidoPoliticoPorId ( partidoId );
    }


    @CrossOrigin
 @PostMapping(value = "/actualizarPartidoPolitico/{partidoId}")
    public PartidoPoliticoDto actualizarPartidoPolitico ( @RequestBody PartidoPoliticoDto partidoPoliticoDto ) {
        if (partidoPoliticoDto.getPartidoId ( ) != 0) {
            return partidoPoliticoService.guardarPartidoPolitico ( partidoPoliticoDto );

        }

        throw new RuntimeException ( "El id no existe" );


    }

}




