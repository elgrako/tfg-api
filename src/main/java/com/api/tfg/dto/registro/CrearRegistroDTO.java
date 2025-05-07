package com.api.tfg.dto.registro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CrearRegistroDTO implements Serializable {

    private static final long serialVersionUID = 2L;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(max = 100, message = "El nombre no puede tener mas de 100 caracteres")
    private String nombre;

    private boolean presentado;
    private boolean validado;
    private boolean pagado;

    private String comentarios;

    @Size(max = 50, message = "El número de talon no puede tener mas de 50 caracteres")
    private String nTalon;
}
