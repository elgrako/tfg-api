package com.api.tfg.repository.seguridad;

import com.api.tfg.entity.Role;
import com.api.tfg.entity.ERole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}