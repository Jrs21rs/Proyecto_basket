package com.ucentral.Escuelabasket.EscuelaBasket.controladores;

import com.ucentral.Escuelabasket.EscuelaBasket.entidades.usuario;
import com.ucentral.Escuelabasket.EscuelaBasket.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auten")
public class ControladorAutenticador {

    @Autowired
    private ServicioUsuarios usuarioServicio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String contrasena) {
        return usuarioServicio.buscarPorUsuario(usuario)
                .filter(u -> passwordEncoder.matches(contrasena, u.getContrasena()))
                .map(u -> "Login exitoso, Rol: " + u.getRol())
                .orElse("Usuario o contraseña incorrectos");
    }
}
