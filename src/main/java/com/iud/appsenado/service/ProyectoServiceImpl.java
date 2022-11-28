package com.iud.appsenado.service;

import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.interfaces.ProyectoServiceDto;
import com.iud.appsenado.mappers.ProyectoMappers;
import com.iud.appsenado.models.Proyecto;
import com.iud.appsenado.models.Senador;
import com.iud.appsenado.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class ProyectoServiceImpl implements ProyectoServiceDto {


    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private ProyectoMappers proyectoMappers;


    @Override
    public ProyectoDto crearProyecto ( ProyectoDto proyectoDto ) {
        Proyecto proyecto = proyectoMappers.mapearEntidad ( proyectoDto );
        if (proyectoDto.getNombre().length()  <= 3) {
            throw new ResourceAccessException ( "El nombre del proyecto no puede ser menor a 3 caracteres" );
        }

        Proyecto nuevoProyecto = proyectoRepository.save ( proyecto );

        ProyectoDto nuevoProyectoResponse = proyectoMappers.mapearDTO ( nuevoProyecto );

        return nuevoProyectoResponse;
    }

    @Override
    public ProyectoDto actualizarProyecto ( ProyectoDto proyectoDto , Integer id ) {
        Proyecto proyecto = proyectoRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el proyecto con id " + id ) );
        proyecto.setNombre ( proyectoDto.getNombre ( ) );
        proyecto.setDescripcion ( proyectoDto.getDescripcion ( ) );
        proyecto.setFechaCreacion ( proyectoDto.getFechaCreacion ( ) );

        Proyecto proyectoActualizado = proyectoRepository.save ( proyecto );

        return proyectoMappers.mapearDTO ( proyectoActualizado );
    }

    @Override
    public Iterable < Proyecto > obtenerProyectos ( ) {
        return proyectoRepository.findAll ( );
    }

    @Override
    public ProyectoDto obtenerProyectoPorId ( Integer id ) {
        Proyecto proyecto = proyectoRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el proyecto con id " + id ) );
        return proyectoMappers.mapearDTO ( proyecto );
    }

    @Override
    public void eliminarProyecto ( Integer id ) {

        Proyecto proyecto = proyectoRepository.findById ( id ).
                orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el proyecto " + id ) );

        proyectoRepository.delete ( proyecto );

    }

}

