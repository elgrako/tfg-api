package com.api.tfg.dto.recursoextra;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecursoExtraOrdinarioDTO {

    @NotNull(message = "El ID de guardia es obligatorio")
    private Long id;

    @NotNull(message = "El numero de expediente es obligatorio")
    @Size(max = 50, message = "El número de expediente no puede exceder los 50 caracteres")
    private Integer nExpediente;
    private Boolean admitido;
}