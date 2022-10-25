package com.iud.appsenado.models;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proyecto_id", unique = true, nullable = false)
    private int proyecto_id;

    @Column(name = "proyecto_nombre", nullable = false)
    private String nombre;

    @Column(name = "proyecto_descripcion", nullable = false)
    private String descripcion;

    @Column(name = "proyecto_fecha_creacion", nullable = false)
    private String fecha_creacion;


    public Proyecto ( ) {
    }

    public Proyecto ( int proyecto_id , String nombre , String descripcion , String fecha_creacion ) {
        this.proyecto_id = proyecto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
    }
}
