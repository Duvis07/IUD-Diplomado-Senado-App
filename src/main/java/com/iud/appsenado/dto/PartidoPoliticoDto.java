package com.iud.appsenado.dto;


import lombok.Data;

import java.util.List;

@Data
public class PartidoPoliticoDto {

    private int partidoId;
    private String nombre;

    private List < SenadorDto > senadores;

    public PartidoPoliticoDto ( ) {
    }

    public PartidoPoliticoDto ( int partidoId , String nombre, List < SenadorDto > senadores ) {
        this.partidoId = partidoId;
        this.nombre = nombre;
        this.senadores = senadores;
    }


}
