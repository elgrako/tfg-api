package com.api.tfg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistroDTO implements Serializable{

    @Serial
    private static final long serialVersionUID = 11823L;

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
