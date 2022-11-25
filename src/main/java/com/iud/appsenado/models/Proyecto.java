package com.iud.appsenado.models;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "responsable", nullable = false)
    private Senador responsable;

    @Column(name = "fechaCreacion", nullable = false)
    private String fechaCreacion;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.REMOVE,
//                    CascadeType.REFRESH
//            })
//    @JoinTable(name = "proyecto_senador",
//            joinColumns = {
//                    @JoinColumn(name = "proyecto_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "senador_id")
//            })
//    private List<Senador> senadores;


    public Proyecto ( ) {
    }


    public Proyecto ( Integer id , String nombre , String descripcion , Senador responsable , String fechaCreacion ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fechaCreacion = fechaCreacion;

    }

}
