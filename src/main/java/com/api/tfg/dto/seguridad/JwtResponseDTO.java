package com.api.tfg.dto.seguridad;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class JwtResponseDTO {
    private String token;
    private Long id;
    private String username;
    private List<String> roles;
}