package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.models.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMappers {

    @Autowired
    private ModelMapper modelMapper;

    public Usuario mapearEntidad ( UsuarioDto usuarioDto ) {
        Usuario usuario = modelMapper.map ( usuarioDto , Usuario.class );
        return usuario;
    }

    public UsuarioDto mapearDTO ( Usuario usuario ) {
        UsuarioDto usuarioDto = modelMapper.map ( usuario , UsuarioDto.class );
        return usuarioDto;
    }
}
