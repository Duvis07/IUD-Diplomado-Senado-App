package com.iud.appsenado.dto;

import com.iud.appsenado.models.Senador;
import lombok.Data;

@Data
public class VotoDto
{

    private int voto_id;
    private SenadorDto senador_id;
    private ProyectoDto proyecto_id;


    public VotoDto ( ) {
    }

    public VotoDto ( int voto_id , SenadorDto senador_id , ProyectoDto proyecto_id ) {
        this.voto_id = voto_id;
        this.senador_id = senador_id;
        this.proyecto_id = proyecto_id;
    }


}
