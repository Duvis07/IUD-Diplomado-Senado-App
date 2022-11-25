package com.iud.appsenado.dto;

import lombok.Data;

import java.util.List;

@Data
public class RolDto {

    private int id;
    private String nombre;

    private List <UsuarioDto> usuarios;

    public RolDto ( ) {
    }

    public RolDto ( int id , String nombre , List < UsuarioDto > usuarios ) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = usuarios;
    }


}
