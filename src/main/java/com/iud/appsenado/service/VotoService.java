package com.iud.appsenado.service;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Voto;
import com.iud.appsenado.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;


    public Voto guardarVoto ( Voto voto ) {
        return votoRepository.save ( voto );
    }

    public Iterable < Voto > obtenerVotos ( ) {
        return votoRepository.findAll ( );
    }

    public void eliminarVoto ( Integer id ) {
        votoRepository.deleteById ( id );
    }

    public Optional < Voto > obtenerVotoPorId ( Integer id ) {
        return votoRepository.findById ( id );


    }

    public Voto actualizarVoto ( Voto voto ) {
        return votoRepository.save ( voto );
    }
}
