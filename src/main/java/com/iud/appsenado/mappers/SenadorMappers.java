package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenadorMappers {

    @Autowired
    private ModelMapper modelMapper;

    public Senador mapearEntidad ( SenadorDto senadorDto ) {
        Senador senador = modelMapper.map ( senadorDto , Senador.class );
        return senador;
    }

    public SenadorDto mapearDTO ( Senador senador ) {
        SenadorDto senadorDto = modelMapper.map ( senador , SenadorDto.class );
        return senadorDto;
    }
}
