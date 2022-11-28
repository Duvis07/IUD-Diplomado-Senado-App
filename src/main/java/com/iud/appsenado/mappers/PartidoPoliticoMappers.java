package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.models.PartidoPolitico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartidoPoliticoMappers {

    @Autowired
    private ModelMapper modelMapper;


    //CONVERTIR DTO A ENTITY
    public PartidoPolitico mapearEntidad ( PartidoPoliticoDto partidoPoliticoDto ) {
        PartidoPolitico partidoPolitico = modelMapper.map ( partidoPoliticoDto , PartidoPolitico.class );
        return partidoPolitico;
    }

    //CONVERTIR ENTITY A DTO
   public    PartidoPoliticoDto mapearDTO ( PartidoPolitico partidoPolitico ) {
        PartidoPoliticoDto partidoPoliticoDto = modelMapper.map ( partidoPolitico , PartidoPoliticoDto.class );
        return partidoPoliticoDto;
    }
}
