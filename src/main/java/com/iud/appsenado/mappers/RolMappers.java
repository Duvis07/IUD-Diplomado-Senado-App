package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.RolDto;
import com.iud.appsenado.models.Rol;

public class RolMappers {

    public Rol rolDtoARol ( RolDto rolDto ) {
        Rol rol = new Rol ( );
        rol.setRolId ( rolDto.getRolId ( ) );
        rol.setNombre ( rolDto.getNombre ( ) );

        return rol;

    }

    public RolDto rolARolDto ( Rol rol ) {
        RolDto rolDto = new RolDto ( );
        rolDto.setRolId ( rol.getRolId ( ) );
        rolDto.setNombre ( rol.getNombre ( ) );

        return rolDto;

    }

}

