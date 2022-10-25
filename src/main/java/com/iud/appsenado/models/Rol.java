package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", unique = true, nullable = false)
    private int rolId;


    @Column(name = "nombreRol", nullable = false)
    private String nombre;


    public Rol ( ) {
    }

    public Rol ( int rolId , String nombre ) {
        this.rolId = rolId;
        this.nombre = nombre;
    }

}
