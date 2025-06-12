package com.api.tfg.dto.recursoguardia;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecursoGuardiaDTO {

    @NotNull(message = "El ID de guardia es obligatorio")
    private Long guardiaId;

    @NotNull(message = "El número de expediente es obligatorio")
    private String nExpediente;

    private Boolean resuelto;
}
