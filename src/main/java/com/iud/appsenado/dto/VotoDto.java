package com.iud.appsenado.dto;

import com.iud.appsenado.models.Proyecto;
import lombok.Data;



@Data
public class VotoDto {

    private int id;
    private SenadorDto senadores;

    private Proyecto proyectos;


    public VotoDto ( ) {
    }

    public VotoDto ( int id , SenadorDto senadores , Proyecto proyectos ) {
        this.id = id;
        this.senadores = senadores;
        this.proyectos = proyectos;
    }

}
