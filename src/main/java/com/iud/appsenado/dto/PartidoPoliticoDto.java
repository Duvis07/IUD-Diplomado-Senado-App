package com.iud.appsenado.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class PartidoPoliticoDto {

    private int id;
    @NotEmpty
    @Size(min = 3, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;



    public PartidoPoliticoDto ( ) {
    }

    public PartidoPoliticoDto ( int id , String nombre) {
        this.id = id;
        this.nombre = nombre;

    }


}
