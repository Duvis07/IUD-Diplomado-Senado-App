package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.PartidoPolitico;


public class PartidoPoliticoMappers {

    public PartidoPolitico partidoPoliticoDtoAPartidoPolitico ( PartidoPoliticoDto partidoPoliticoDto ) {
        PartidoPolitico partidoPolitico = new PartidoPolitico ( );
        partidoPolitico.setPartidoId ( partidoPoliticoDto.getPartidoId ( ) );
        partidoPolitico.setNombre ( partidoPoliticoDto.getNombre ( ) );

        return partidoPolitico;

    }

    public PartidoPoliticoDto partidoPoliticoAPartidoPoliticoDto ( PartidoPolitico partidoPolitico ) {
        PartidoPoliticoDto partidoPoliticoDto = new PartidoPoliticoDto ( );
        partidoPoliticoDto.setPartidoId ( partidoPolitico.getPartidoId ( ) );
        partidoPoliticoDto.setNombre ( partidoPolitico.getNombre ( ) );

        return partidoPoliticoDto;

    }
}
