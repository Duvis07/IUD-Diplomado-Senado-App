package com.iud.appsenado.mappers;


import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Proyecto;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.models.Voto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VotoMappers {

    public Voto votoDtoAVoto ( VotoDto votoDto ) {
        Voto voto = new Voto ( );
        voto.setVotoId ( votoDto.getVotoId ( ) );


        Proyecto proyecto = new Proyecto ( );
        proyecto.setProyectoId ( votoDto.getProyectoId ( ).getProyectoId ( ) );
        voto.setProyectoId ( proyecto );

        Senador senador = new Senador ( );
        senador.setSenadorId ( votoDto.getSenadorId ( ).getSenadorId ( ) );
        voto.setSenadorId ( senador );


        return voto;
    }

    public VotoDto votoAVotoDto ( Voto voto ) {
        VotoDto votoDto = new VotoDto ( );
        votoDto.setVotoId ( voto.getVotoId ( ) );
        BeanUtils.copyProperties ( voto , votoDto );

        ProyectoDto proyectoDto = new ProyectoDto ( );
        proyectoDto.setProyectoId ( voto.getProyectoId ( ).getProyectoId ( ) );
        votoDto.setProyectoId ( proyectoDto );

        SenadorDto senadorDto = new SenadorDto ( );
        senadorDto.setSenadorId ( voto.getSenadorId ( ).getSenadorId ( ) );
        votoDto.setSenadorId ( senadorDto );


        return votoDto;
    }


}
