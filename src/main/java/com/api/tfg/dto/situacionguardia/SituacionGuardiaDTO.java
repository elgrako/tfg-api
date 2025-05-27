package com.api.tfg.dto.situacionguardia;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SituacionGuardiaDTO {
    private Long id;

    @NotNull(message = "El ID de guardia es obligatorio")
    private Long guardiaId;

    @Size(max = 1000, message = "Los comentarios no pueden exceder los 1000 caracteres")
    private String comentarios;

    @Size(max = 50, message = "El número de talón no puede exceder los 50 caracteres")
    private String nTalon;

    @Size(max = 50, message = "El valor en euros no puede exceder los 50 caracteres")
    private String euros;

    private Boolean presentado;
    private Boolean validado;
    private Boolean pagado;
}