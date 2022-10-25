package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class ProyectoDto {

    private int proyecto_id;
    private String nombre;
    private String descripcion;
    private String fecha_creacion;


    public ProyectoDto ( ) {
    }

    public ProyectoDto ( int proyecto_id , String nombre , String descripcion , String fecha_creacion ) {
        this.proyecto_id = proyecto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
    }

}
