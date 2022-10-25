package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class ProyectoDto {

    private int proyectoId;
    private String nombre;
    private String descripcion;
    private String fechaCreacion;


    public ProyectoDto ( ) {
    }

    public ProyectoDto ( int proyectoId , String nombre , String descripcion , String fechaCreacion ) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

}
