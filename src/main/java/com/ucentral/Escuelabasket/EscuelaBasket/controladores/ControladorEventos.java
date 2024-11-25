package com.ucentral.Escuelabasket.EscuelaBasket.controladores;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.Eventos;
import com.ucentral.Escuelabasket.EscuelaBasket.servicios.EventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ControladorEventos {
    @Autowired
    private EventoServicio eventoServicio;

    @GetMapping("/calendario")
    public String mostrarCalendario(Model model) {
        try {
            List<Eventos> eventos = eventoServicio.obtenerTodos();
            model.addAttribute("eventos", eventos);
        } catch (Exception e) {
            System.err.println("Error al cargar eventos: " + e.getMessage());
            model.addAttribute("eventos", List.of()); // Lista vacía si ocurre un error
        }
        return "calendario";
    }


    @PostMapping("/Registrarevento")
    public String guardarEvento(@ModelAttribute Eventos evento, RedirectAttributes redirectAttributes) {
        try {

            // Guardar el entrenador en la base de datos
            eventoServicio.guardar(evento);

            redirectAttributes.addFlashAttribute("mensaje", "Evento registrado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar el evento.");
        }
        return "redirect:/calendario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoServicio.eliminar(id);
        return "redirect:/eventos";
    }
}

