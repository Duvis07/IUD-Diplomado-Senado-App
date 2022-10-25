package com.iud.appsenado.models;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProyecto", unique = true, nullable = false)
    private int proyectoId;

    @Column(name = "nombreProyecto", nullable = false)
    private String nombre;

    @Column(name = "descripcionProyecto", nullable = false)
    private String descripcion;

    @Column(name = "fechaCreacionProyecto", nullable = false)
    private String fechaCreacion;


    public Proyecto ( ) {
    }

    public Proyecto ( int proyectoId , String nombre , String descripcion , String fechaCreacion ) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }
}
