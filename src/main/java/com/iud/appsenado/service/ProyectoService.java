package com.iud.appsenado.service;

import com.iud.appsenado.models.Proyecto;
import com.iud.appsenado.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;


    public Proyecto guardarProyecto ( Proyecto proyecto ) {
        return proyectoRepository.save ( proyecto );

    }
    public Iterable < Proyecto > obtenerProyectos ( ) {
        return proyectoRepository.findAll ( );
    }

    public void eliminarProyecto ( Integer id ) {
        proyectoRepository.deleteById ( id );
    }

    public Optional < Proyecto > obtenerProyectoPorId ( Integer id ) {
        return proyectoRepository.findById ( id );
    }

    public Proyecto actualizarProyecto ( Proyecto proyecto ) {
        return proyectoRepository.save ( proyecto );
    }
}
