package com.ucentral.Escuelabasket.EscuelaBasket.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Representante")
@Table(name = "Repre_bk")
public class representante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REPRE")
    @SequenceGenerator(name = "SEQ_REPRE", sequenceName = "SEQ_REPRE", allocationSize = 1)
    @Column(name = "RPR_CODIGO", nullable = false)
    private long serial;

    @Column(name = "REPRE_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "REPRE_CONTACTO", nullable = false)
    private char contacto;

    @Column(name = "REPRE_USUARIO", unique = true, nullable = false)
    private String usuario;

    @Column(name = "REPRE_CONTRASEÑA", nullable = false)
    private String contraseña;
}