package com.iud.appsenado.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "usuario_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol")
    private Rol rol;


    public Usuario ( ) {
    }

    public Usuario ( int usuario_id , String nombre , String correo , String contrasena , Rol rol ) {
        this.usuario_id = usuario_id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
}
