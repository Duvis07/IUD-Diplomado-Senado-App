package com.iud.appsenado.models;

import lombok.Data;


import javax.persistence.*;


@Data
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "responsable")
    private Senador responsable;

    @Column(name = "fechaCreacion")
    private String fechaCreacion;


    public Proyecto ( ) {
    }


    public Proyecto ( Integer id , String nombre , String descripcion , Senador responsable , String fechaCreacion ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fechaCreacion = fechaCreacion;

    }

}
