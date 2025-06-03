package com.api.tfg.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apelacion_guardia")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApelacionGuardia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guardia_id", nullable = false)
    private Guardia guardia;

    @Column(name = "n_expediente")
    private String nExpediente;

    @Column(columnDefinition = "boolean default false")
    private Boolean admitido = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean presentado = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean sentencia = false;
}