package com.api.tfg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "registros")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    private String dni;

    private String nExpediente;

    private Double euros;

    private boolean presentado;
    private boolean validado;
    private boolean pagado;

    private Integer nTalon;

    private String comentarios;
}
