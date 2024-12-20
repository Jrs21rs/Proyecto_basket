package com.ucentral.Escuelabasket.EscuelaBasket.repositorios;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositorioEventos extends JpaRepository<Eventos, Long> {
    List<Eventos> findByfechaBetween(LocalDateTime start, LocalDateTime end);
}
