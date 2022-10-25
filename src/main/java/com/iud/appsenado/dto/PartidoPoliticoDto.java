package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class PartidoPoliticoDto {

    private int partidoId;
    private String nombre;

    public PartidoPoliticoDto ( ) {
    }

    public PartidoPoliticoDto ( int partidoId , String nombre ) {
        this.partidoId = partidoId;
        this.nombre = nombre;
    }


}
