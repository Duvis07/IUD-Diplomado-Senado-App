package com.iud.appsenado.controller;

import java.util.Collections;

import com.iud.appsenado.dto.LoginDTO;
import com.iud.appsenado.dto.RegistroDTO;
import com.iud.appsenado.models.Rol;
import com.iud.appsenado.models.Usuario;
import com.iud.appsenado.repository.RolRepository;
import com.iud.appsenado.repository.UsuarioRepository;
import com.iud.appsenado.security.JWTAuthResonseDTO;
import com.iud.appsenado.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private RolRepository rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/iniciarSesion")
    public ResponseEntity < JWTAuthResonseDTO > authenticateUser ( @RequestBody LoginDTO loginDTO ) {
        Authentication authentication = authenticationManager.authenticate ( new UsernamePasswordAuthenticationToken ( loginDTO.getUsernameOrEmail ( ) , loginDTO.getPassword ( ) ) );

        SecurityContextHolder.getContext ( ).setAuthentication ( authentication );

        //obtenemos el token del jwtTokenProvider
        String token = jwtTokenProvider.generarToken ( authentication );

        return ResponseEntity.ok ( new JWTAuthResonseDTO ( token ) );
    }

    @PostMapping("/registrar")
    public ResponseEntity < ? > registrarUsuario ( @RequestBody RegistroDTO registroDTO ) {
        if (usuarioRepositorio.existsByUsername ( registroDTO.getUsername ( ) )) {
            return new ResponseEntity <> ( "El nombre de usuario ya existe" , HttpStatus.BAD_REQUEST );
        }

        if (usuarioRepositorio.existsByEmail ( registroDTO.getEmail ( ) )) {
            return new ResponseEntity <> ( "El Email ingresado ya se encuentra en la BD" , HttpStatus.BAD_REQUEST );
        }

        Usuario usuario = new Usuario ( );
        usuario.setNombre ( registroDTO.getNombre ( ) );
        usuario.setUsername ( registroDTO.getUsername ( ) );
        usuario.setEmail ( registroDTO.getEmail ( ) );
        usuario.setPassword ( passwordEncoder.encode ( registroDTO.getPassword ( ) ) );

        Rol roles = rolRepositorio.findByNombre ( "ROLE_USER" ).get ( );
        usuario.setRoles ( Collections.singleton ( roles ) );

        usuarioRepositorio.save ( usuario );
        return new ResponseEntity <> ( "Usuario registrado exitosamente" , HttpStatus.OK );
    }
}