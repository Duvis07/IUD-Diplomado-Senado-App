package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.models.Proyecto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProyectoMappers {

    @Autowired
    private ModelMapper modelMapper;

    public Proyecto mapearEntidad ( ProyectoDto proyectoDto ) {
        Proyecto proyecto = modelMapper.map ( proyectoDto , Proyecto.class );
        return proyecto;
    }

    public ProyectoDto mapearDTO ( Proyecto proyecto ) {
        ProyectoDto proyectoDto = modelMapper.map ( proyecto , ProyectoDto.class );
        return proyectoDto;
    }
}
