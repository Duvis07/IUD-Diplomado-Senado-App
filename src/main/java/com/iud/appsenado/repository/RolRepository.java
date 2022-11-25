package com.iud.appsenado.repository;

import com.iud.appsenado.models.Rol;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolRepository extends CrudRepository < Rol, Integer> {

    public Optional <Rol> findByNombre( String nombre);

}

