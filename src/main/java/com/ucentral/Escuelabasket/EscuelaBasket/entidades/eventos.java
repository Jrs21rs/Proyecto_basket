package com.ucentral.Escuelabasket.EscuelaBasket.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Eventos")
@Table(name = "Evenet_bk")

public class eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVEN")
    @SequenceGenerator(name = "SEQ_EVEN", sequenceName = "SEQ_EVEN", allocationSize = 1)
    @Column(name = "EVE_CODIGO", nullable = false)
    private long serial;

    @Column(name = "EVE_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EVE_CONTACTO", nullable = false)
    private char contacto;

    @Column(name = "EVE_USUARIO", unique = true, nullable = false)
    private String usuario;

    @Column(name = "EVE_CONTRASEÑA", nullable = false)
    private String contraseña;
}
