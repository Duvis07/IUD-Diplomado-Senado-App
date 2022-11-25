package com.iud.appsenado.service;

import com.iud.appsenado.models.Rol;
import com.iud.appsenado.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;


    public Rol guardarRol ( Rol rol ) {
        return rolRepository.save ( rol );
    }

    public Iterable < Rol > obtenerRoles ( ) {
        return rolRepository.findAll ( );
    }

    public void eliminarRol ( Integer id ) {
        rolRepository.deleteById ( id );
    }

    public Optional < Rol > obtenerRolPorId ( Integer id ) {
        return rolRepository.findById ( id );
    }

    public Rol actualizarRol ( Rol rol ) {
        return rolRepository.save ( rol );
    }
}
