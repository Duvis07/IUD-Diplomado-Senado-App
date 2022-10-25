package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Voto;
import org.springframework.beans.BeanUtils;

public class VotoMappers {

    public Voto votoDtoAVoto( VotoDto votoDto) {
        Voto voto = new Voto();
        voto.setVotoId (votoDto.getVotoId ());
        BeanUtils.copyProperties ( votoDto , voto );




        return voto;
    }

    public VotoDto votoAVotoDto(Voto voto) {
        VotoDto votoDto = new VotoDto();
        votoDto.setVotoId (voto.getVotoId ());
        BeanUtils.copyProperties ( voto , votoDto );


        return votoDto;
    }



}
