package com.ucentral.Escuelabasket.EscuelaBasket.servicios;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.usuario;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioAdministrador;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioEntrenador;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioRepresentante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioUsuarios {

    @Autowired
    private RepositorioAdministrador administradorRepositorio;

    @Autowired
    private RepositorioEntrenador entrenadorRepositorio;

    @Autowired
    private RepositorioRepresentante representanteRepositorio;

    public Optional<usuario> buscarPorUsuario(String usuario) {
        return administradorRepositorio.findByUsuario(usuario)
                .map(admin -> (usuario) admin)
                .or(() -> entrenadorRepositorio.findByUsuario(usuario).map(entrenador -> entrenador))
                .or(() ->  representanteRepositorio.findByUsuario(usuario).map(representante -> representante));
    }

}