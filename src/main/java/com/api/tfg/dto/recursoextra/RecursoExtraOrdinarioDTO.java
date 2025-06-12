package com.api.tfg.dto.recursoextra;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecursoExtraOrdinarioDTO {

    @NotNull(message = "El ID de guardia es obligatorio")
    private Long guardiaId;

    @NotNull(message = "El numero de expediente es obligatorio")
    private String nExpediente;

    private Boolean admitido;
}