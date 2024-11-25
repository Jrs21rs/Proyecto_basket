package com.ucentral.Escuelabasket.EscuelaBasket.repositorios;

import aj.org.objectweb.asm.commons.Remapper;
import com.ucentral.Escuelabasket.EscuelaBasket.entidades.Representante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RepositorioRepresentante extends JpaRepository<Representante, Long> {

    Optional<Representante>findById(Long serial);

    Optional findByUsuario(String usuario);
}
