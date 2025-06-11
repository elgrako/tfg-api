package com.api.tfg.dto.recursoguardia;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecursoGuardiaDTO {

    private Long id;

    @NotNull(message = "El ID de guardia es obligatorio")
    private Long guardiaId;

    @NotNull(message = "El número de expediente es obligatorio")
    @Size(max = 50, message = "El número de expediente no puede exceder los 50 caracteres")
    private String nExpediente;

    private Boolean resuelto;
}
