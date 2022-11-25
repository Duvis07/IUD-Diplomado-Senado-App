package com.iud.appsenado.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProyectoDto {

    private int id;
    private String nombre;
    private String descripcion;

    private String responsable;
    private String fechaCreacion;

    private List<SenadorDto> senadores;


    public ProyectoDto ( ) {
    }

    public ProyectoDto ( int id , String nombre , String descripcion , String responsable , String fechaCreacion , List < SenadorDto > senadores ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fechaCreacion = fechaCreacion;
        this.senadores = senadores;
    }
}
