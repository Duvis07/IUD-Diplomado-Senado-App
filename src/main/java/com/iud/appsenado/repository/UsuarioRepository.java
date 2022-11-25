package com.iud.appsenado.repository;


import com.iud.appsenado.models.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository < Usuario, Integer> {

    Optional <Usuario> findByEmail( String email);
    Optional<Usuario> findByUsernameOrEmail(String username, String email);
    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String username);


}
