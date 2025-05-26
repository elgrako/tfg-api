package com.api.tfg.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "Guardia")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Guardia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreAsistido;

    @Column(nullable = false)
    private String diaActuacion;

    @Column(columnDefinition = "boolean default false")
    private Boolean porJuzgado = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean cobrado = false;

    @OneToOne(mappedBy = "guardia", cascade = CascadeType.ALL, orphanRemoval = true)
    private SituacionGuardia situacion;

    @OneToMany(mappedBy = "guardia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApelacionGuardia> apelaciones;

    @OneToMany(mappedBy = "guardia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecursoGuardia> recursos;

    @OneToMany(mappedBy = "guardia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecursoExtraOrdinario> recursosExtraOrdinarios;
}