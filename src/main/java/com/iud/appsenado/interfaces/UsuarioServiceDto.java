package com.iud.appsenado.interfaces;

import com.iud.appsenado.dto.UsuarioDto;
import com.iud.appsenado.models.Usuario;

public interface UsuarioServiceDto {
public UsuarioDto crearUsuario( UsuarioDto usuarioDto );

    public UsuarioDto actualizarUsuario( UsuarioDto usuarioDto , Integer id);

    public Iterable< Usuario > obtenerUsuarios();

    public UsuarioDto obtenerUsuarioPorId( Integer id);

    public void eliminarUsuario(Integer id);
}
