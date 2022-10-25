package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "partidoPolitico")
public class PartidoPolitico {

    @Id
    @Column(name = "idPartido", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partidoId;

    @Column(name = "nombrePartido", nullable = false)
    private String nombre;


    public PartidoPolitico ( ) {
    }

    public PartidoPolitico ( int partidoId , String nombre ) {
        this.partidoId = partidoId;
        this.nombre = nombre;
    }

}
