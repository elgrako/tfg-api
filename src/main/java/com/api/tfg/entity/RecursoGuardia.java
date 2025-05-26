package com.api.tfg.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RecursoGuardia")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecursoGuardia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guardia_id", nullable = false)
    private Guardia guardia;

    private String nExpediente;

    @Column(columnDefinition = "boolean default false")
    private Boolean resuelto = false;
}