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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Partido_id")
    private PartidoPolitico partido;

    public Senador() {
    }

    public Senador( String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }
    public Senador( String nombre, String departamento, PartidoPolitico partido ) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido = partido;
    }

    public Senador( int senadorId , String nombre, String departamento, PartidoPolitico partido ) {
        this.senadorId = senadorId;
        this.nombre = nombre;
        this.departamento = departamento;
        this.partido = partido;
    }

    public int getSenadorId() {
        return senadorId;
    }

    public void setSenadorId(int senadorId) {
        this.senadorId = senadorId;
    }

    @Override
    public String toString() {
        return "Senador{" +
                "senadorId=" + senadorId +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
