package com.api.tfg.service.seguridad;

import com.api.tfg.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAllUsuarios();
    Usuario findUsuarioById(Long id);
    Usuario findUsuarioByUsername(String username);
    Usuario addUsuario(Usuario user);
    Usuario updateUsuario(Long id, Usuario newUsuario);
    boolean deleteUsuario(Long id);
    boolean existsByUsername(String username);
}