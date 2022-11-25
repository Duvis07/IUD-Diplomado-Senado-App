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

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.REMOVE ,
//                    CascadeType.REFRESH
//            })
//    @JoinTable(name = "votos_senadores",
//            joinColumns = {
//                    @JoinColumn(name = "senador_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "voto_id")
//            })
//    private List < Voto > votos;


    public Senador ( ) {


    }

    public Senador ( int id , String nombre , String departamento , PartidoPolitico partido ) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido = partido;

    }


}
