package com.iud.appsenado.service;

import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.mappers.ProyectoMappers;
import com.iud.appsenado.models.Proyecto;
import com.iud.appsenado.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    ProyectoMappers proyectoMappers = new ProyectoMappers ( );

    public ProyectoDto guardarProyecto ( ProyectoDto proyectoDto ) {
        Proyecto proyecto = proyectoMappers.proyectoDtoAProyecto ( proyectoDto );
        proyectoRepository.save ( proyecto );

        return proyectoDto;
    }

    public Iterable < Proyecto > obtenerProyectos ( ) {
        return proyectoRepository.findAll ( );
    }

    public void eliminarProyecto ( int proyectoId ) {
        proyectoRepository.deleteById ( proyectoId );
    }

    public ProyectoDto obtenerProyectoPorId ( int proyectoId ) {
        Proyecto proyecto = proyectoRepository.findById ( proyectoId ).get ( );
        ProyectoDto proyectoDto = proyectoMappers.proyectoAProyectoDto ( proyecto );
        return proyectoDto;
    }
}
