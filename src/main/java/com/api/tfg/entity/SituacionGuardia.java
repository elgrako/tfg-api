package com.api.tfg.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "situacion_guardia")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SituacionGuardia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "guardia_id", nullable = false)
    private Guardia guardia;

    @Column(length = 1000)
    private String comentarios;

    @Column(name = "n_talon")
    private String nTalon;

    @Column
    private String euros;

    @Column(columnDefinition = "boolean default false")
    private Boolean presentado = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean validado = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean pagado = false;
}