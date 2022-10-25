package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class SenadorDto {

    private int senadorId;

    private String nombre;

    private String departamento;

    private PartidoPoliticoDto partidoId;


    public SenadorDto ( ) {
    }

    public SenadorDto ( int senadorId , String nombre , String departamento , PartidoPoliticoDto partidoId ) {
        this.senadorId = senadorId;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partidoId = partidoId;
    }

}
