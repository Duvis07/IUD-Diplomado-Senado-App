package com.iud.appsenado.service;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.repository.SenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SenadorService {

    @Autowired
    private SenadorRepository senadorRepository;


    public Senador guardarSenador( Senador senador ) {
          return senadorRepository.save( senador );
        }

    public Iterable < Senador > obtenerSenadores ( ) {
        return senadorRepository.findAll ( );
    }

    public void eliminarSenador ( Integer id ) {
        senadorRepository.deleteById ( id );
    }

    public Optional < Senador > obtenerSenadorPorId ( Integer id ) {
     return senadorRepository.findById ( id );

    }
    public Senador actualizarSenador ( Senador senador ) {
        return senadorRepository.save ( senador );
    }
}
