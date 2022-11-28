package com.iud.appsenado.service;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.interfaces.PartidoPoliticoServiceDTO;
import com.iud.appsenado.mappers.PartidoPoliticoMappers;
import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.repository.PartidoPoliticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class PartidoPoliticoServiceImpl implements PartidoPoliticoServiceDTO {


    @Autowired
    private PartidoPoliticoRepository partidoPoliticoRepository;


    private PartidoPoliticoMappers partidoPoliticoMappers;

    public PartidoPoliticoServiceImpl ( PartidoPoliticoMappers partidoPoliticoMappers ) {
        this.partidoPoliticoMappers = partidoPoliticoMappers;
    }


    @Override
    public PartidoPoliticoDto crearPartidoPolitico ( PartidoPoliticoDto partidoPoliticoDto ) {
        PartidoPolitico partidoPolitico = partidoPoliticoMappers.mapearEntidad ( partidoPoliticoDto );

        if (partidoPoliticoDto.getNombre ( ).length ( ) <= 3) {
            throw new ResourceAccessException ( "El nombre del partido politico no puede ser menor a 3 caracteres" );
        }
        PartidoPolitico nuevoPartidoPolitico = partidoPoliticoRepository.save ( partidoPolitico );

        PartidoPoliticoDto nuevoPartidoResponse = partidoPoliticoMappers.mapearDTO ( nuevoPartidoPolitico );

        return nuevoPartidoResponse;
    }

    @Override
    public PartidoPoliticoDto actualizarPartidoPolitico ( PartidoPoliticoDto partidoPoliticoDto , Integer id ) {
        PartidoPolitico partidoPolitico = partidoPoliticoRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el partido politico con id " + id ) );

        partidoPolitico.setNombre ( partidoPoliticoDto.getNombre ( ) );

        PartidoPolitico partidoPoliticoActualizado = partidoPoliticoRepository.save ( partidoPolitico );

        return partidoPoliticoMappers.mapearDTO ( partidoPoliticoActualizado );

    }

    @Override
    public Iterable < PartidoPolitico > obtenerPartidosPoliticos ( ) {
        return partidoPoliticoRepository.findAll ( );
    }

    @Override
    public PartidoPoliticoDto obtenerPartidoPoliticoPorId ( Integer id ) {
        PartidoPolitico partidoPolitico = partidoPoliticoRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el partido politico con id " + id ) );
        return partidoPoliticoMappers.mapearDTO ( partidoPolitico );
    }

    @Override
    public void eliminarPartidoPolitico ( Integer id ) {

        PartidoPolitico partidoPolitico = partidoPoliticoRepository.findById ( id ).
                orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el partido politico con id " + id ) );
        partidoPoliticoRepository.delete ( partidoPolitico );

    }


}

