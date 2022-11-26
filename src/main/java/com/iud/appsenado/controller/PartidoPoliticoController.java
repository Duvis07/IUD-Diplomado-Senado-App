package com.iud.appsenado.controller;


import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.service.PartidoPoliticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartidoPoliticoController {
    //@PreAuthorize("hasAnyRole('STUDENT', 'TEACHER')")  ---> Autorizar varios Roles
    @Autowired
    private PartidoPoliticoService partidoPoliticoService;

    @CrossOrigin
    @PreAuthorize( "hasRole('ADMIN')" )
    @PostMapping
    public PartidoPolitico guardarPartidoPolitico (@Valid @RequestBody PartidoPolitico partidoPolitico ) {
        return partidoPoliticoService.guardarPartidoPolitico ( partidoPolitico );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < PartidoPolitico > obtenerPartidosPoliticos ( ) {
        return partidoPoliticoService.obtenerPartidosPoliticos ( );
    }

    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @DeleteMapping("/{id}")
    public void eliminarPartidoPolitico ( @PathVariable Integer id )
    {
        partidoPoliticoService.eliminarPartidoPolitico ( id );
    }


//cambiar metodo a put
    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @GetMapping("/{id}")
    public Optional<PartidoPolitico>  obtenerPartidoPoliticoPorId ( @PathVariable Integer id ) {
        return partidoPoliticoService.obtenerPartidoPoliticoPorId ( id );

    }


    @CrossOrigin
    @PreAuthorize ( "hasRole('ADMIN')" )
    @PutMapping(value = "/{id}")
    public PartidoPolitico actualizarPartidoPolitico (@Valid @RequestBody PartidoPolitico partidoPolitico ) {
        return partidoPoliticoService.actualizarPartidoPolitico ( partidoPolitico );


    }

}




