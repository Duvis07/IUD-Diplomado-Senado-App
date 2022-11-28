package com.iud.appsenado.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "senadores")
public class Senador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "departamento")
    private String departamento;
    @ManyToOne
    @JoinColumn(name = "Partido_id")
    private PartidoPolitico partido;



    public Senador ( ) {


    }

    public Senador ( int id , String nombre , String departamento , PartidoPolitico partido ) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido = partido;

    }


}
