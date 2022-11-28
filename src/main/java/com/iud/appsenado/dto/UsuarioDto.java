package com.iud.appsenado.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    private int id;
    private String nombre;

    private String email;

    private String password;

    private  String Username;

    private List < String > roles;


    public UsuarioDto ( ) {
    }

    public UsuarioDto ( int id , String nombre , String email , String password , String username , List < String > roles ) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        Username = username;
        this.roles = roles;
    }
}
