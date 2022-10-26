package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;

public class SenadorMappers {


    public SenadorDto senadorASenadorDto ( Senador senador ) {
        var senadorDto = new SenadorDto ( );
        senador.getSenadorId ();
        senador.getNombre ();
        senador.getDepartamento ();
        senador.getPartidoId ();

        return senadorDto;
    }

    public Senador senadorDtoASenador ( SenadorDto senadorDto ) {
           var senador = new Senador ( );
            senadorDto.getSenadorId ();
            senadorDto.getNombre ();
            senadorDto.getDepartamento ();
            senadorDto.getPartidoId ();

            return senador;

    }


}
