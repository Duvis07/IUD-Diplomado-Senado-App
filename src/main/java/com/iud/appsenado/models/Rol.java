package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id", unique = true, nullable = false)
    private int rol_id;


    @Column(name = "rol_nombre", nullable = false)
    private String nombre;


    public Rol ( ) {
    }

    public Rol ( int rol_id , String nombre ) {
        this.rol_id = rol_id;
        this.nombre = nombre;
    }

}
