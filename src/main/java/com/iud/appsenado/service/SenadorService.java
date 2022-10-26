package com.iud.appsenado.service;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.mappers.SenadorMappers;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.repository.SenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenadorService {

    @Autowired
    private SenadorRepository senadorRepository;

    SenadorMappers senadorMappers = new SenadorMappers ( );

    public SenadorDto guardarSenador( SenadorDto senadorDto ) {
           Senador senador = senadorMappers.senadorDtoASenador ( senadorDto);
            senadorRepository.save ( senador );
            return senadorDto;
        }

    public Iterable < Senador > obtenerSenadores ( ) {
        return senadorRepository.findAll ( );
    }

    public void eliminarSenador ( int senadorId ) {
        senadorRepository.deleteById ( senadorId );
    }

    public SenadorDto obtenerSenadorPorId ( int senadorId ) {
        Senador senador = senadorRepository.findById ( senadorId
        ).get ( );
        SenadorDto senadorDto = senadorMappers.senadorASenadorDto ( senador );
        return senadorDto;

    }
}
