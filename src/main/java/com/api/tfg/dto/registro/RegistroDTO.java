package com.api.tfg.dto.registro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistroDTO implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String nombre;

    @NotBlank
    private String dni;

    private String nExpediente;

    private Double euros;

    private boolean presentado;
    private boolean validado;
    private boolean pagado;

    private Integer nTalon;

    private String comentarios;
}
