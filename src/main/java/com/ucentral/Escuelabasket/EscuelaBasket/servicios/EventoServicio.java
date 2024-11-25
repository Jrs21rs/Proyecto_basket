package com.ucentral.Escuelabasket.EscuelaBasket.servicios;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.Eventos;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServicio {
    @Autowired
    private RepositorioEventos eventoRepositorio;

    /**
     * Obtiene todos los eventos.
     * @return Lista de eventos.
     */
    public List<Eventos> obtenerTodos() {
        return eventoRepositorio.findAll();
    }

    /**
     * Guarda un nuevo evento o actualiza uno existente.
     * @param evento Evento a guardar o actualizar.
     * @return Evento guardado.
     */
    public Eventos guardar(Eventos evento) {
        return eventoRepositorio.save(evento);
    }

    /**
     * Obtiene un evento por su ID.
     * @param id ID del evento.
     * @return Evento encontrado o null si no existe.
     */
    public Optional<Eventos> obtenerPorId(Long id) {
        return eventoRepositorio.findById(id);
    }

    /**
     * Elimina un evento por su ID.
     * @param id ID del evento a eliminar.
     */
    public void eliminar(Long id) {
        if (eventoRepositorio.existsById(id)) {
            eventoRepositorio.deleteById(id);
        } else {
            throw new IllegalArgumentException("El evento con ID " + id + " no existe.");
        }
    }

    /**
     * Busca eventos entre un rango de fechas.
     * @param inicio Fecha de inicio.
     * @param fin Fecha de fin.
     * @return Lista de eventos dentro del rango.
     */
    public List<Eventos> buscarPorRangoDeFechas(LocalDateTime inicio, LocalDateTime fin) {
        return eventoRepositorio.findByfechaBetween(inicio, fin);
    }
}
