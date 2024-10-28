package com.ucentral.Escuelabasket.EscuelaBasket.repositorios;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RepositorioEntrenador extends JpaRepository<entrenador, Long> {

        Optional<entrenador> findByUsuario(String usuario);

}
