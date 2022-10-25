package com.iud.appsenado.dto;

import lombok.Data;

@Data
public class RolDto {

    private int rol_id;
    private String nombre;

    public RolDto ( ) {
    }

    public RolDto ( int rol_id , String nombre ) {
        this.rol_id = rol_id;
        this.nombre = nombre;
    }


}
