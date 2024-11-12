package com.ucentral.Escuelabasket.EscuelaBasket.controladores;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.Entrenador;
import com.ucentral.Escuelabasket.EscuelaBasket.repositorios.RepositorioEntrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControladorAdmin {
    @Autowired
    private RepositorioEntrenador entrenadorRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/Menuadmin")
    public String mostrarMenuAdmin() {
        return "Menuadmin"; // Este archivo debe llamarse Menuadmin.html y estar en src/main/resources/templates/
    }


    // Método para registrar el entrenador
    @PostMapping("/registrarEntrenador")
    public String registrarEntrenador(@ModelAttribute Entrenador entrenador, RedirectAttributes redirectAttributes) {
        try {
            // Codificar la contraseña antes de guardar
            entrenador.setContrasena(passwordEncoder.encode(entrenador.getContrasena()));

            // Guardar el entrenador en la base de datos
            entrenadorRepositorio.save(entrenador);

            redirectAttributes.addFlashAttribute("mensaje", "Entrenador registrado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar el entrenador.");
        }
        return "redirect:/Menuadmin";
    }

}
