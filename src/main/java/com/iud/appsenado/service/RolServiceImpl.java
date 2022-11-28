package com.iud.appsenado.service;

import com.iud.appsenado.dto.RolDto;
import com.iud.appsenado.interfaces.RolServiceDto;
import com.iud.appsenado.mappers.RolMappers;
import com.iud.appsenado.models.Rol;
import com.iud.appsenado.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class RolServiceImpl implements RolServiceDto {

    @Autowired
    private RolMappers rolMappers;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public RolDto crearRol ( RolDto rolDto ) {
        Rol rol = rolMappers.mapearEntidad ( rolDto );
        if (rolDto.getNombre().length() <= 3) {
            throw new ResourceAccessException ( "El nombre del rol no puede ser menor a 3 caracteres" );
        }
        Rol nuevoRol = rolRepository.save ( rol );
        RolDto nuevoRolResponse = rolMappers.mapearDTO ( nuevoRol );
        return nuevoRolResponse;
    }

    @Override
    public RolDto actualizarRol ( RolDto rolDto , Integer id ) {
        Rol rol = rolRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No se encontro el rol con Id " + id ) );

        rol.setNombre ( rolDto.getNombre ( ) );

        Rol rolActualizado = rolRepository.save ( rol );

        return rolMappers.mapearDTO ( rolActualizado );
    }

    @Override
    public Iterable < Rol > obtenerRoles ( ) {
        return rolRepository.findAll ( );
    }

    @Override
    public RolDto obtenerRolPorId ( Integer id ) {
        Rol rol = rolRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el rol con el id " + id ) );
        return rolMappers.mapearDTO ( rol );
    }

    @Override
    public void eliminarRol ( Integer id ) {
        Rol rol = rolRepository.findById ( id )
                .orElseThrow ( ( ) -> new ResourceAccessException ( "No existe el rol con el id " + id ) );
        rolRepository.delete ( rol );

    }


}
