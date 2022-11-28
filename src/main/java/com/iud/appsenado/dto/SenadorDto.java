package com.iud.appsenado.dto;


import lombok.Data;


@Data
public class SenadorDto {

    private int id;

    private String nombre;

    private String departamento;

    private PartidoPoliticoDto partido;



    public SenadorDto ( ) {
    }

    public SenadorDto ( int id , String nombre , String departamento , PartidoPoliticoDto partido ) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido = partido;

    }

}
