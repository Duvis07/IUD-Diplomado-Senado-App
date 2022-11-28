package com.iud.appsenado.interfaces;

import com.iud.appsenado.dto.RolDto;
import com.iud.appsenado.models.Rol;

public interface RolServiceDto {
    public RolDto crearRol( RolDto rolDto );

    public RolDto actualizarRol( RolDto rolDto , Integer id);

    public Iterable< Rol > obtenerRoles();

    public RolDto obtenerRolPorId( Integer id);

    public void eliminarRol(Integer id);
}

