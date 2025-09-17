package com.api.tfg.dto.apelacionguardia;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApelacionGuardiaDTO {
    private Long id;

    @NotNull(message = "El ID de guardia es obligatorio")
    private Long guardiaId;

    @Size(max = 50, message = "El número de expediente no puede exceder los 50 caracteres")
    private String nExpediente;

    private Boolean admitido;

    private Boolean presentado;

    private Boolean sentencia;
}