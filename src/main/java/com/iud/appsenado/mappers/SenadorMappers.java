package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;
import org.springframework.beans.BeanUtils;

public class SenadorMappers {


    public Senador senadorDtoASenador ( SenadorDto senadorDto ) {
        Senador senador = new Senador ( );
        senador.setSenadorId ( senadorDto.getSenadorId ( ) );
        senador.setNombre ( senadorDto.getNombre ( ) );
        senador.setDepartamento ( senadorDto.getDepartamento ( ) );
        BeanUtils.copyProperties ( senadorDto , senador );

        return senador;
    }

    public SenadorDto senadorASenadorDto ( Senador senador ) {
        SenadorDto senadorDto = new SenadorDto ( );
        senadorDto.setSenadorId ( senador.getSenadorId ( ) );
        senadorDto.setNombre ( senador.getNombre ( ) );
        senadorDto.setDepartamento ( senador.getDepartamento ( ) );
        BeanUtils.copyProperties ( senador , senadorDto );

        return senadorDto;
    }


}
