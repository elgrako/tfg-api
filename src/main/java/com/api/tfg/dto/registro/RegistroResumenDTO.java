package com.api.tfg.dto.registro;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegistroResumenDTO {
    private Long id;
    private String nombre;
    private String nExpediente;
    private BigDecimal euros;
    private Boolean pagado;
}