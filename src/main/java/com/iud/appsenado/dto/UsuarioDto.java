package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private int usuarioId;
    private String nombre;

    private String correo;
    private String contrasena;

    private RolDto rol;


    public UsuarioDto ( ) {
    }

    public UsuarioDto ( int usuarioId , String nombre , String correo , String contrasena , RolDto rol ) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
}
