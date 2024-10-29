package com.ucentral.Escuelabasket.EscuelaBasket.servicios;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.usuario;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioAdministrador;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioEntrenador;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioRepresentante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioUsuarios implements UserDetailsService {



    @Autowired
    private RepositorioAdministrador administradorRepositorio;

    @Autowired
    private RepositorioEntrenador entrenadorRepositorio;

    @Autowired
    private RepositorioRepresentante representanteRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) buscarPorUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }

    public Optional<usuario> buscarPorUsuario(String usuario) {
        return administradorRepositorio.findByUsuario(usuario)
                .map(admin -> (usuario) admin)
                .or(() -> entrenadorRepositorio.findByUsuario(usuario).map(entrenador -> entrenador))
                .or(() ->  representanteRepositorio.findByUsuario(usuario).map(representante -> representante));
    }

}