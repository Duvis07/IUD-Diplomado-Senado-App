package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "partidoPolitico")
public class PartidoPolitico {

    @Id
    @Column(name = "partidoId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partidoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;


    @OneToMany (mappedBy = "senadorId")
    private List<Senador> senadores;

    public PartidoPolitico ( ) {
    }

    public PartidoPolitico ( int partidoId , String nombre, List < Senador > senadores ) {
        this.partidoId = partidoId;
        this.nombre = nombre;
        this.senadores = senadores;
    }




    }


