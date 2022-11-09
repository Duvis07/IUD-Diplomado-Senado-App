package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.models.Senador;
import org.springframework.stereotype.Component;

@Component
public class SenadorMappers {


    public SenadorDto senadorASenadorDto ( Senador senador ) {
        var senadorDto = new SenadorDto ( );
        senadorDto.setSenadorId ( senador.getSenadorId ( ) );
        senadorDto.setNombre ( senador.getNombre ( ) );
        senadorDto.setDepartamento ( senador.getDepartamento ( ) );

        PartidoPoliticoDto partidoPoliticoDto = new PartidoPoliticoDto ( );
        partidoPoliticoDto.setPartidoId ( senador.getPartido ( ).getPartidoId ( ) );
        senadorDto.setPartido ( partidoPoliticoDto );

        return senadorDto;
    }

    public Senador senadorDtoASenador ( SenadorDto senadorDto ) {
        var senador = new Senador ( );
        senador.setSenadorId ( senadorDto.getSenadorId ( ) );
        senador.setNombre ( senadorDto.getNombre ( ) );
        senador.setDepartamento ( senadorDto.getDepartamento ( ) );

        PartidoPolitico partidoPolitico = new PartidoPolitico ( );
        partidoPolitico.setPartidoId ( senadorDto.getPartido ( ).getPartidoId ( ) );
        senador.setPartido ( partidoPolitico );


        return senador;

    }


}
