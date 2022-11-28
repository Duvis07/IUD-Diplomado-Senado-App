package com.iud.appsenado.controller;


import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.interfaces.PartidoPoliticoServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/partidos")
public class PartidoPoliticoController {
    //@PreAuthorize("hasAnyRole('STUDENT', 'TEACHER')")  ---> Autorizar varios Roles

    @Autowired
    private PartidoPoliticoServiceDTO partidoPoliticoServiceDTO;


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity < PartidoPoliticoDto > guardarPartidoPolitico ( @Valid @RequestBody PartidoPoliticoDto partidoPoliticoDto ) {
        return new ResponseEntity <> ( partidoPoliticoServiceDTO.crearPartidoPolitico ( partidoPoliticoDto ) , HttpStatus.CREATED );
    }

    @CrossOrigin
    @GetMapping
    public Iterable < PartidoPolitico > obtenerPartidosPoliticos ( ) {
        return partidoPoliticoServiceDTO.obtenerPartidosPoliticos ( );
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity < String > eliminarPartidoPolitico ( @PathVariable Integer id ) {
        partidoPoliticoServiceDTO.eliminarPartidoPolitico ( id );
        return new ResponseEntity <> ( "El partido politico con id " + id + " fue correctamente eliminado" , HttpStatus.OK );

    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity < PartidoPoliticoDto > obtenerPartidoPoliticoPorId ( @PathVariable Integer id ) {
        return ResponseEntity.ok ( partidoPoliticoServiceDTO.obtenerPartidoPoliticoPorId ( id ) );
    }


    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping(value = "/{id}")
    public ResponseEntity < PartidoPoliticoDto > actualizarPartido ( @Valid @RequestBody PartidoPoliticoDto partidoPoliticoDto, @PathVariable Integer id ) {
      PartidoPoliticoDto partidoPoliticoDtoRespuesta = partidoPoliticoServiceDTO.actualizarPartidoPolitico ( partidoPoliticoDto , id );
        return new ResponseEntity <> ( partidoPoliticoDtoRespuesta , HttpStatus.OK );
    }


}




