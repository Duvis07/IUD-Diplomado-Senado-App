package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "voto")
public class Voto {

    @Id
    @Column(name = "votoId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int votoId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proyectoId")
    private Proyecto proyectoId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "senadorId")
    private Senador senadorId;


    public Voto() {
    }

    public Voto( int votoId , Proyecto proyectoId , Senador senadorId ) {
        this.votoId = votoId;
        this.proyectoId = proyectoId;
        this.senadorId = senadorId;
    }


}
