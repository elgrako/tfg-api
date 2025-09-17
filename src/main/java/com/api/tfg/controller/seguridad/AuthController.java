package com.api.tfg.controller.seguridad;

import com.api.tfg.entity.ERole;
import com.api.tfg.entity.Role;
import com.api.tfg.entity.Usuario;
import com.api.tfg.repository.seguridad.IRoleRepository;
import com.api.tfg.repository.seguridad.IUserRepository;
import com.api.tfg.dto.seguridad.AuthRequest;
import com.api.tfg.dto.seguridad.AuthResponse;
import com.api.tfg.dto.seguridad.RegisterRequest;
import com.api.tfg.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        var user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtUtils.generateToken(user.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("Ya existe un usuario con ese username");
        }

        Set<Role> roles = new HashSet<>();
        for (String nombre : request.roles()) {
            ERole rol = ERole.valueOf(nombre);
            Role role = roleRepository.findByName(rol)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombre));
            roles.add(role);
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(request.username());
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setRoles(roles);

        return ResponseEntity.ok(userRepository.save(usuario));
    }
}
