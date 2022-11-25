package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;


    @Column(name = "rol", nullable = false)
    private String nombre;


    public Rol ( ) {
    }

    public Rol ( int id , String nombre ) {
        this.id = id;
        this.nombre = nombre;
    }

}
