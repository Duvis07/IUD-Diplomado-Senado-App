package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class VotoDto {

    private int votoId;
    private SenadorDto senadorId;
    private ProyectoDto proyectoId;


    public VotoDto ( ) {
    }

    public VotoDto ( int votoId , SenadorDto senadorId , ProyectoDto proyectoId ) {
        this.votoId = votoId;
        this.senadorId = senadorId;
        this.proyectoId = proyectoId;
    }


}
