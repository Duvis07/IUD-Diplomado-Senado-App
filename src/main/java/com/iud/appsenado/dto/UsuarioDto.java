package com.iud.appsenado.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    private int id;
    private String nombre;

    private String correo;
    private String contrasena;

    private List < String > roles;


    public UsuarioDto ( ) {
    }

    public UsuarioDto ( int id , String nombre , String correo , String contrasena , List < String > roles ) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.roles = roles;
    }
}
