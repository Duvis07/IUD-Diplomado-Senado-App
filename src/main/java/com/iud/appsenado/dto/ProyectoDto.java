package com.iud.appsenado.dto;

import lombok.Data;


@Data
public class ProyectoDto {

    private int id;
    private String nombre;
    private String descripcion;
    private SenadorDto responsable;
    private String fechaCreacion;


    public ProyectoDto ( ) {
    }

    public ProyectoDto ( int id , String nombre , String descripcion , SenadorDto responsable , String fechaCreacion ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fechaCreacion = fechaCreacion;

    }

}