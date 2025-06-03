package com.api.tfg.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recurso_extra_ordinario")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecursoExtraOrdinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guardia_id", nullable = false)
    private Guardia guardia;

    @Column(name = "n_expediente")
    private Integer nExpediente;

    @Column(columnDefinition = "boolean default false")
    private Boolean admitido = false;
}