package com.ucentral.Escuelabasket.EscuelaBasket.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Administrador")
@Table(name = "Adminis_bk")
public class administrador implements Serializable,usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADMINS")
    @SequenceGenerator(name = "SEQ_ADMINS", sequenceName = "SEQ_ADMINS", allocationSize = 1)
    @Column(name = "ADM_CODIGO", nullable = false)
    private long serial;

    @Column(name = "ADMIN_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "ADMIN_CONTACTO", nullable = false)
    private char contacto;

    @Column(name = "ADMIN_USUARIO", unique = true, nullable = false)
    private String usuario;

    @Column(name = "ADMIN_CONTRASEÑA", nullable = false)
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
        return "Administrador";
    }

}
