package com.iud.appsenado.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "senador")
public class Senador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "senador_id", unique = true, nullable = false)
    private int senador_id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "departamento", nullable = false)
    private  String departamento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partido")
    private Partido_Politico  partido_id;

    public Senador() {
    }

    public Senador(int senador_id, String nombre, String departamento, Partido_Politico partido_id) {
        this.senador_id = senador_id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido_id = partido_id;
    }

}
