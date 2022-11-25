package com.iud.appsenado.dto;


import lombok.Data;

import java.util.List;

@Data
public class PartidoPoliticoDto {

    private int id;
    private String nombre;

    private List < SenadorDto > senadores;

    public PartidoPoliticoDto ( ) {
    }

    public PartidoPoliticoDto ( int id , String nombre, List < SenadorDto > senadores ) {
        this.id = id;
        this.nombre = nombre;
        this.senadores = senadores;
    }


}
