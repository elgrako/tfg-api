package com.api.tfg.dto.registro;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegistroDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede exceder los 255 caracteres")
    private String nombre;

    @Size(max = 20, message = "El DNI no puede exceder los 20 caracteres")
    private String dni;

    @Size(max = 50, message = "El número de expediente no puede exceder los 50 caracteres")
    private String nExpediente;

    @DecimalMin(value = "0.0", message = "El valor no puede ser negativo")
    private BigDecimal euros;

    @Email(message = "Debe ser un email válido")
    @Size(max = 100, message = "El email no puede exceder los 100 caracteres")
    private String email;

    @PositiveOrZero(message = "El teléfono debe ser un número positivo")
    private Integer telefono;

    private Boolean presentado;
    private Boolean validado;
    private Boolean pagado;
    private Integer nTalon;

    @Size(max = 1000, message = "Los comentarios no pueden exceder los 1000 caracteres")
    private String comentarios;
}