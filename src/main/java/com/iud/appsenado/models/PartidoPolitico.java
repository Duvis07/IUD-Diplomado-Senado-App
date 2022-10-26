package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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


    @OneToMany (mappedBy = "senadorId")//cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Senador> senadores;

    public PartidoPolitico ( ) {
    }

    public PartidoPolitico ( int partidoId , String nombre ) {
        this.partidoId = partidoId;
        this.nombre = nombre;
    }

    public void agregarSenadores(Senador elSenador){
        if (senadores==null) senadores = new ArrayList<>();
        senadores.add(elSenador);
        elSenador.setPartido(this);


    }

}
