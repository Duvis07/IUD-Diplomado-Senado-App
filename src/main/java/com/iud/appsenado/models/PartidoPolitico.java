package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "partidoPolitico")
public class PartidoPolitico {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "nombre", nullable = false)
    private String nombre;



    public PartidoPolitico ( ) {
    }

    public PartidoPolitico ( Integer id , String nombre ) {
        this.id = id;
        this.nombre = nombre;



    }

}


