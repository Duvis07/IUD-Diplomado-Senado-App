package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.models.Proyecto;

public class ProyectoMappers {

    public Proyecto proyectoDtoAProyecto ( ProyectoDto proyectoDto ) {
        Proyecto proyecto = new Proyecto ( );
        proyecto.setProyectoId ( proyectoDto.getProyectoId ( ) );
        proyecto.setNombre ( proyectoDto.getNombre ( ) );
        proyecto.setDescripcion ( proyectoDto.getDescripcion ( ) );
        proyecto.setFechaCreacion ( proyectoDto.getFechaCreacion ( ) );

        return proyecto;

    }

    public ProyectoDto proyectoAProyectoDto ( Proyecto proyecto ) {
        ProyectoDto proyectoDto = new ProyectoDto ( );
        proyectoDto.setProyectoId ( proyecto.getProyectoId ( ) );
        proyectoDto.setNombre ( proyecto.getNombre ( ) );
        proyectoDto.setDescripcion ( proyecto.getDescripcion ( ) );
        proyectoDto.setFechaCreacion ( proyecto.getFechaCreacion ( ) );

        return proyectoDto;

    }
}
