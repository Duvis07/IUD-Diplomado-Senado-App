package com.iud.appsenado.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "senadores")
public class Senador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSenador", unique = true, nullable = false)
    private int senadorId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "departamento")
    private  String departamento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partido")
    private PartidoPolitico partidoId;

    public Senador() {
    }

    public Senador( int senadorId , String nombre, String departamento, PartidoPolitico partidoId ) {
        this.senadorId = senadorId;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partidoId = partidoId;
    }

}
