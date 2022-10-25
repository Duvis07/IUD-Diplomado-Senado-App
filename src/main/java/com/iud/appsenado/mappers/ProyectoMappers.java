package com.iud.appsenado.mappers;

import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.models.Proyecto;

public class ProyectoMappers {

    public Proyecto proyectoDtoAProyecto ( ProyectoDto proyectoDto ) {
        Proyecto proyecto = new Proyecto ( );
        proyecto.setProyecto_id ( proyectoDto.getProyecto_id ( ) );
        proyecto.setNombre ( proyectoDto.getNombre ( ) );
        proyecto.setDescripcion ( proyectoDto.getDescripcion ( ) );
        proyecto.setFecha_creacion ( proyectoDto.getFecha_creacion ( ) );

        return proyecto;

    }

    public ProyectoDto proyectoAProyectoDto ( Proyecto proyecto ) {
        ProyectoDto proyectoDto = new ProyectoDto ( );
        proyectoDto.setProyecto_id ( proyecto.getProyecto_id ( ) );
        proyectoDto.setNombre ( proyecto.getNombre ( ) );
        proyectoDto.setDescripcion ( proyecto.getDescripcion ( ) );
        proyectoDto.setFecha_creacion ( proyecto.getFecha_creacion ( ) );

        return proyectoDto;

    }
}
