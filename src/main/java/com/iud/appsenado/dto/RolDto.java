package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class RolDto {

    private int rolId;
    private String nombre;

    public RolDto ( ) {
    }

    public RolDto ( int rolId , String nombre ) {
        this.rolId = rolId;
        this.nombre = nombre;
    }


}
