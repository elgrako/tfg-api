package com.api.tfg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Datos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column
    private String dni;

    @Column
    private String nExpediente;

    @Column(precision = 10, scale = 2)
    private BigDecimal euros;

    @Column
    private String email;

    @Column
    private Integer telefono;

    @Column(columnDefinition = "boolean default false")
    private Boolean presentado = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean validado = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean pagado = false;

    @Column
    private Integer nTalon;

    @Column(length = 1000)
    private String comentarios;
}