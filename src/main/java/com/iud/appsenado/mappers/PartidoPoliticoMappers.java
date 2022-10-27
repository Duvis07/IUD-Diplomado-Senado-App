package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.models.Senador;

import java.util.List;

public class PartidoPoliticoMappers {

    public PartidoPolitico partidoPoliticoDtoAPartidoPolitico ( PartidoPoliticoDto partidoPoliticoDto ) {
        PartidoPolitico partidoPolitico = new PartidoPolitico ( );
        partidoPolitico.setPartidoId ( partidoPoliticoDto.getPartidoId ( ) );
        partidoPolitico.setNombre ( partidoPoliticoDto.getNombre ( ) );

        SenadorDto senadorDto = new SenadorDto ( );
        senadorDto.setSenadorId ( partidoPoliticoDto.getSenadores ( ).get ( 0 ).getSenadorId ( ) );
        partidoPolitico.setSenadores ( (List < Senador >) senadorDto );

        return partidoPolitico;

    }

    public PartidoPoliticoDto partidoPoliticoAPartidoPoliticoDto ( PartidoPolitico partidoPolitico ) {
        PartidoPoliticoDto partidoPoliticoDto = new PartidoPoliticoDto ( );
        partidoPoliticoDto.setPartidoId ( partidoPolitico.getPartidoId ( ) );
        partidoPoliticoDto.setNombre ( partidoPolitico.getNombre ( ) );

        Senador senador = new Senador ( );
        senador.setSenadorId ( partidoPolitico.getSenadores ( ).get ( 0 ).getSenadorId ( ) );
        partidoPoliticoDto.setSenadores ( (List < SenadorDto >) senador );

        return partidoPoliticoDto;

    }
}
