package com.iud.appsenado.service;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.mappers.VotoMappers;
import com.iud.appsenado.models.Voto;
import com.iud.appsenado.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    VotoMappers votoMappers;


    public VotoDto guardarVoto ( VotoDto votoDto ) {
        votoRepository.save ( votoMappers.votoDtoAVoto ( votoDto ) );
        return votoDto;
    }

    public Iterable < Voto > obtenerVotos ( ) {
        return votoRepository.findAll ( );
    }

    public void eliminarVoto ( int votoId ) {
        votoRepository.deleteById ( votoId );
    }

    public VotoDto obtenerVotoPorId ( int votoId ) {
        Voto voto = votoRepository.findById ( votoId
        ).get ( );
        VotoDto votoDto = votoMappers.votoAVotoDto ( voto );
        return votoDto;
    }


}
