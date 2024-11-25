package com.ucentral.Escuelabasket.EscuelaBasket.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Evenet_bk")
public class Eventos{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVEN")
    @SequenceGenerator(name = "SEQ_EVEN", sequenceName = "SEQ_EVEN", allocationSize = 1)
    @Column(name = "EVE_CODIGO", nullable = false)
    private Long id;

    @Column(name = "EVE_TIPO", nullable = false)
    private String tipo;

    @Column(name = "EVE_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EVE_DESCRIPCION")
    private String descripcion;

    @Column(name = "EVE_FECHA", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "EVE_UBICACION", nullable = false)
    private String ubicacion;

    @Column(name = "EVE_CATEGORIA", nullable = false)
    private String categoria;

}