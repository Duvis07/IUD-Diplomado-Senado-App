package com.iud.appsenado.dto;

import com.iud.appsenado.models.Proyecto;
import lombok.Data;




@Data
public class VotoDto {

    private int id;
    private Proyecto proyecto;

    private String votante;
    private boolean aprobado;


    public VotoDto ( ) {
    }

    public VotoDto ( int id, Proyecto proyecto, String votante, boolean aprobado ) {
        this.id = id;
        this.proyecto = proyecto;
        this.votante = votante;
        this.aprobado = aprobado;
    }
}
