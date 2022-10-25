package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class SenadorDto {

    private int senador_id;

    private String nombre;

    private String departamento;

    private Partido_PoliticoDto partido_id;


    public SenadorDto ( ) {
    }

    public SenadorDto ( int senador_id , String nombre , String departamento , Partido_PoliticoDto partido_id ) {
        this.senador_id = senador_id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido_id = partido_id;
    }

}
