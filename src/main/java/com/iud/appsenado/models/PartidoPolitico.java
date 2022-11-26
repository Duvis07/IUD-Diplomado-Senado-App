package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "partidoPolitico")
public class PartidoPolitico {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;



    public PartidoPolitico ( ) {
    }

    public PartidoPolitico ( Integer id , String nombre ) {
        this.id = id;
        this.nombre = nombre;



    }

}


