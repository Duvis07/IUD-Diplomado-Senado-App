package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "votos")
public class Voto {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "senador_id")
//    private  Senador senadores;

    @Column(name= "nombre_votante", nullable = false)
    private String votante;

    @Column(name="aprobado", nullable = false)
    private Boolean aprobado;

    public Voto() {
    }

    public Voto(int id, Proyecto proyecto, String votante, Boolean aprobado) {
        this.id = id;
        this.proyecto = proyecto;
        this.votante = votante;
        this.aprobado = aprobado;
    }
}
