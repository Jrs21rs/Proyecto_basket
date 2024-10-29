package com.ucentral.Escuelabasket.EscuelaBasket.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Administrador")
@Table(name = "Adminis_bk")
public class administrador implements Serializable,usuario, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADMINS")
    @SequenceGenerator(name = "SEQ_ADMINS", sequenceName = "SEQ_ADMINS", allocationSize = 1)
    @Column(name = "ADM_CODIGO", nullable = false)
    private long serial;

    @Column(name = "ADMIN_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "ADMIN_CONTACTO", nullable = false)
    private String contacto;

    @Column(name = "ADMIN_USUARIO", unique = true, nullable = false)
    private String usuario;

    @Column(name = "ADMIN_CONTRASENA", nullable = false)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
