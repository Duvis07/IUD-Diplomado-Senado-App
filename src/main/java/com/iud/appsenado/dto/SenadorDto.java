package com.iud.appsenado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SenadorDto {

    private int id;

    private String nombre;
    @JsonProperty("departamento")
    private String departamento;

    private PartidoPoliticoDto partido;

    private List < VotoDto > votos;


    public SenadorDto ( ) {
    }

    public SenadorDto ( int id , String nombre , String departamento , PartidoPoliticoDto partido , List < VotoDto > votos ) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido = partido;
        this.votos = votos;
    }

}
