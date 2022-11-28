package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.RolDto;
import com.iud.appsenado.models.Rol;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolMappers {

    @Autowired
    private ModelMapper modelMapper;

    public Rol mapearEntidad ( RolDto rolDto ) {
        Rol rol = modelMapper.map ( rolDto , Rol.class );
        return rol;
    }

    public RolDto mapearDTO ( Rol rol ) {
        RolDto rolDto = modelMapper.map ( rol , RolDto.class );
        return rolDto;
    }
}
