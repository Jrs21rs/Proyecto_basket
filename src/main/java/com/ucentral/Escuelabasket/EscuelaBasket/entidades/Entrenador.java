package com.ucentral.Escuelabasket.EscuelaBasket.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Entrenador")
@Table(name = "Entren_bk")
public class Entrenador implements Serializable,usuario {

    @Id
    @Column(name = "ENTR_CEDULA", nullable = false)
    private long cedula;

    @Column(name = "ENTR_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "ENTR_CONTACTO", nullable = false)
    private double contacto;

    @Column(name = "ENTR_USUARIO", unique = true, nullable = false)
    private String usuario;

    @Column(name = "ENTR_CONTRASENA", nullable = false)
    private String contrasena;

    @Override
    public String getUsuario() {
        return this.usuario;
    }

    @Override
    public String getContrasena() {
        return this.contrasena;
    }

    @Override
    public String getRol() {
        return "Entrenador";
    }
}
