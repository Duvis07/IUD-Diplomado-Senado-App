package com.iud.appsenado.service;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.interfaces.SenadorServiceDto;
import com.iud.appsenado.mappers.SenadorMappers;
import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.repository.SenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class SenadorServiceImpl implements SenadorServiceDto {

    @Autowired
    private SenadorMappers senadorMappers;

    @Autowired
    private SenadorRepository senadorRepository;

    @Override
    public SenadorDto crearSenador ( SenadorDto senadorDto ) {
        Senador senador = senadorMappers.mapearEntidad ( senadorDto );
        if (senadorDto.getNombre().length() <= 3) {
            throw new ResourceAccessException ( "El nombre del senador no puede ser menor a 3 caracteres" );
        }
        Senador nuevoSenador = senadorRepository.save ( senador );

        SenadorDto nuevoSenadorResponse = senadorMappers.mapearDTO ( nuevoSenador );

        return nuevoSenadorResponse;
    }

    @Override
    public SenadorDto actualizarSenador ( SenadorDto senadorDto , Integer id ) {

        Senador senador = senadorRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el senador con id " + id ) );

        senador.setNombre ( senadorDto.getNombre ( ) );
        senador.setDepartamento ( senadorDto.getDepartamento ( ) );
        Senador senadorActualizado = senadorRepository.save ( senador );

        return senadorMappers.mapearDTO ( senadorActualizado );
    }

    @Override
    public Iterable < Senador > obtenerSenadores ( ) {
        return senadorRepository.findAll ( );
    }

    @Override
    public SenadorDto obtenerSenadorPorId ( Integer id ) {
        Senador senador = senadorRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el senador con id " + id ) );
        return senadorMappers.mapearDTO ( senador );
    }

    @Override
    public void eliminarSenador ( Integer id ) {
        Senador senador = senadorRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el senador con id " + id ) );
        senadorRepository.delete ( senador );

    }
}

