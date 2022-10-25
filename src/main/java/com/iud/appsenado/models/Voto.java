package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "voto")
public class Voto {

    @Id
    @Column(name = "voto_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voto_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto")
    private Proyecto proyecto_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "senador")
    private Senador senador_id;


    public Voto() {
    }

    public Voto(int voto_id, Proyecto proyecto_id, Senador senador_id) {
        this.voto_id = voto_id;
        this.proyecto_id = proyecto_id;
        this.senador_id = senador_id;
    }


}
