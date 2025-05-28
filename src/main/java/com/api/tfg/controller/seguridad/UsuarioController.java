package com.api.tfg.controller.seguridad;

import com.api.tfg.entity.Usuario;
import com.api.tfg.exception.ConflictException;
import com.api.tfg.exception.ResourceNotFoundException;
import com.api.tfg.mapper.Mapper;
import com.api.tfg.service.seguridad.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "CRUD de usuarios del sistema")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private Mapper mapper;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        if(usuario == null) {
            throw new ResourceNotFoundException("Usuario", id);
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario")
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        if (usuarioService.existsByUsername(usuario.getUsername())) {
            throw new ConflictException("Ya existe un usuario con el nombre: " + usuario.getUsername());
        }

        Usuario creado = usuarioService.addUsuario(usuario);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario existente")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario actualizado = usuarioService.updateUsuario(id, usuario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    @SecurityRequirement(name = "User Find")
    @Operation(summary = "Buscar usuario por nombre de usuario")
    public ResponseEntity<Usuario> getByUsername(@PathVariable String username) {
        Usuario usuario = usuarioService.findUsuarioByUsername(username);
        return ResponseEntity.ok(usuario);
    }
}
