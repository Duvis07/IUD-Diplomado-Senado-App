package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Voto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VotoMappers {

    @Autowired
    private ModelMapper modelMapper;

    public Voto mapearEntidad ( VotoDto votoDto ) {
        Voto voto = modelMapper.map ( votoDto , Voto.class );
        return voto;
    }

    public VotoDto mapearDTO ( Voto voto ) {
        VotoDto votoDto = modelMapper.map ( voto , VotoDto.class );
        return votoDto;
    }
}
