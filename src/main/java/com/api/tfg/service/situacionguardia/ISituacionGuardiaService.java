package com.api.tfg.service.situacionguardia;

import com.api.tfg.entity.SituacionGuardia;
import java.util.Optional;

public interface ISituacionGuardiaService {
    Optional<SituacionGuardia> findByGuardiaId(Long guardiaId);
    SituacionGuardia createSituacion(SituacionGuardia situacion);
    SituacionGuardia updateSituacion(Long id, SituacionGuardia situacion);
    boolean deleteSituacion(Long id);
}