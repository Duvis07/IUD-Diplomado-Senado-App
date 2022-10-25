package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private int usuario_id;
    private String nombre;

    private String correo;
    private String contrasena;

    private RolDto rol;


    public UsuarioDto ( ) {
    }

    public UsuarioDto ( int usuario_id , String nombre , String correo , String contrasena , RolDto rol ) {
        this.usuario_id = usuario_id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
}
