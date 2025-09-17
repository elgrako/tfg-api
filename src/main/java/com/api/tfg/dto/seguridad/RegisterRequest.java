package com.api.tfg.dto.seguridad;

import java.util.Set;

public record RegisterRequest(String username, String password, Set<String> roles) {

}
