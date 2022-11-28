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

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @Column(name= "nombre_votante", nullable = false)
    private String votante;

    @Column(name="aprobado", nullable = false)
    private boolean aprobado;

    public Voto() {
    }

    public Voto(int id, Proyecto proyecto, String votante, boolean aprobado) {
        this.id = id;
        this.proyecto = proyecto;
        this.votante = votante;
        this.aprobado = aprobado;
    }
}
