package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.Partido_PoliticoDto;
import com.iud.appsenado.models.Partido_Politico;

public class PartidoPoliticoMappers {

    public Partido_Politico partidoPoliticoDtoAPartidoPolitico ( Partido_PoliticoDto partidoPoliticoDto ) {
        Partido_Politico partidoPolitico = new Partido_Politico ( );
        partidoPolitico.setPartido_id ( partidoPoliticoDto.getPartido_id ( ) );
        partidoPolitico.setNombre ( partidoPoliticoDto.getNombre ( ) );

        return partidoPolitico;

    }

    public Partido_PoliticoDto partidoPoliticoAPartidoPoliticoDto ( Partido_Politico partidoPolitico ) {
        Partido_PoliticoDto partidoPoliticoDto = new Partido_PoliticoDto ( );
        partidoPoliticoDto.setPartido_id ( partidoPolitico.getPartido_id ( ) );
        partidoPoliticoDto.setNombre ( partidoPolitico.getNombre ( ) );

        return partidoPoliticoDto;

    }
}
