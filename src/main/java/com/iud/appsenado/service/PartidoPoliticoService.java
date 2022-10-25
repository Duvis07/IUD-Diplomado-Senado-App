package com.iud.appsenado.service;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.mappers.PartidoPoliticoMappers;
import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.repository.PartidoPoliticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoPoliticoService {

    @Autowired
    private PartidoPoliticoRepository partidoPoliticoRepository;

    PartidoPoliticoMappers partidoPoliticoMappers = new PartidoPoliticoMappers ( );

    public PartidoPoliticoDto guardarPartidoPolitico ( PartidoPoliticoDto partidoPoliticoDto ) {
        PartidoPolitico partidoPolitico = partidoPoliticoMappers.partidoPoliticoDtoAPartidoPolitico ( partidoPoliticoDto );
        partidoPoliticoRepository.save ( partidoPolitico );
        return partidoPoliticoDto;

    }

    public Iterable < PartidoPolitico > obtenerPartidosPoliticos ( ) {
        return partidoPoliticoRepository.findAll ( );
    }


    public  void eliminarPartidoPolitico ( int partidoId ) {
        partidoPoliticoRepository.deleteById ( partidoId );
    }


   public PartidoPoliticoDto obtenerPartidoPoliticoPorId ( int partidoId ) {
        PartidoPolitico partidoPolitico = partidoPoliticoRepository.findById ( partidoId ).get ( );
        PartidoPoliticoDto partidoPoliticoDto = partidoPoliticoMappers.partidoPoliticoAPartidoPoliticoDto ( partidoPolitico );
        return partidoPoliticoDto;
    }





}



