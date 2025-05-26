package com.api.tfg.dto.guardia;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GuardiaResumenDTO {
    private Long id;
    private String nombreAsistido;
    private String diaActuacion;
    private Boolean cobrado;
}