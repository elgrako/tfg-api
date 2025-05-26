package com.api.tfg.service.seguridad;

import com.api.tfg.entity.Usuario;
import com.api.tfg.repository.seguridad.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return (List<Usuario>) userRepository.findAll();
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public Usuario findUsuarioByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + username));
    }

    @Override
    public Usuario addUsuario(Usuario user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Ya existe un usuario con el nombre: " + user.getUsername());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario newUsuario) {
        Usuario existingUsuario = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con el id: " + id));

        if (!existingUsuario.getUsername().equals(newUsuario.getUsername()) &&
                userRepository.existsByUsername(newUsuario.getUsername())) {
            throw new IllegalArgumentException("Ya existe un usuario con el nombre: " + newUsuario.getUsername());
        }

        newUsuario.setId(id);
        if (newUsuario.getPassword() != null && !newUsuario.getPassword().isEmpty()) {
            newUsuario.setPassword(passwordEncoder.encode(newUsuario.getPassword()));
        } else {
            newUsuario.setPassword(existingUsuario.getPassword());
        }

        return userRepository.save(newUsuario);
    }

    @Override
    public boolean deleteUsuario(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("No se encontró el usuario con el id: " + id);
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}