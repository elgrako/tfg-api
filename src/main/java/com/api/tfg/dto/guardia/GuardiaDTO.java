package com.api.tfg.dto.guardia;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GuardiaDTO {
    private Long id;

    @NotBlank(message = "El nombre del asistido no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede exceder los 255 caracteres")
    private String nombreAsistido;

    @NotBlank(message = "La fecha de actuación no puede estar vacía")
    private String diaActuacion;

    private Boolean porJuzgado;
    private Boolean cobrado;
}