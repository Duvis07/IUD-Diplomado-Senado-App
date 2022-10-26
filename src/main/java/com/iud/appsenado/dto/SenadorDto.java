package com.iud.appsenado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SenadorDto {

    private int senadorId;

    private String nombre;
    @JsonProperty("departamento")
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
