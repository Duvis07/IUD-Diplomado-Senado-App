package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class Partido_PoliticoDto {

    private int partido_id;
    private String nombre;

    public Partido_PoliticoDto ( ) {
    }

    public Partido_PoliticoDto ( int partido_id , String nombre ) {
        this.partido_id = partido_id;
        this.nombre = nombre;
    }


}
