package com.api.tfg.repository.situacionguardia;

import com.api.tfg.entity.SituacionGuardia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISituacionGuardiaRepository extends CrudRepository<SituacionGuardia, Long> {
    Optional<SituacionGuardia> findByGuardiaId(Long guardiaId);
}