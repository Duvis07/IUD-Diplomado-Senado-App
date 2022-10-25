package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "partido_politico")
public class Partido_Politico {

    @Id
    @Column(name = "partido_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partido_id;

    @Column(name = "partido_nombre", nullable = false)
    private String nombre;


    public Partido_Politico ( ) {
    }

    public Partido_Politico ( int partido_id , String nombre ) {
        this.partido_id = partido_id;
        this.nombre = nombre;
    }

}
