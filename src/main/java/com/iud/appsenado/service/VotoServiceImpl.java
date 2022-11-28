package com.iud.appsenado.service;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.interfaces.VotoServiceDto;
import com.iud.appsenado.mappers.VotoMappers;
import com.iud.appsenado.models.Voto;
import com.iud.appsenado.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class VotoServiceImpl implements VotoServiceDto {

    @Autowired
    private VotoMappers votoMappers;

    @Autowired
    private VotoRepository votoRepository;

    @Override
    public VotoDto crearVoto ( VotoDto votoDto ) {
        Voto voto = votoMappers.mapearEntidad ( votoDto );

        Voto nuevoVoto = votoRepository.save ( voto );

        VotoDto nuevoVotoResponse = votoMappers.mapearDTO ( nuevoVoto );

        return nuevoVotoResponse;
    }

    @Override
    public VotoDto actualizarVoto ( VotoDto votoDto , Integer id ) {

        Voto voto = votoRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el voto con id " + id ) );

        voto.setVotante ( votoDto.getVotante ( ) );
        voto.setAprobado ( votoDto.isAprobado ( ) );

        Voto votoActualizado = votoRepository.save ( voto );

        return votoMappers.mapearDTO ( votoActualizado );

    }

    @Override
    public Iterable < Voto > obtenerVotos ( ) {
        return votoRepository.findAll ( );
    }

    @Override
    public VotoDto obtenerVotoPorId ( Integer id ) {
        Voto voto = votoRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el voto con id " + id ) );
        return votoMappers.mapearDTO ( voto );
    }

    @Override
    public void eliminarVoto ( Integer id ) {
        votoRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el voto con id " + id ) );
        votoRepository.deleteById ( id );

    }


}

