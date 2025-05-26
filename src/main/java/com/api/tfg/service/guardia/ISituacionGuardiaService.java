package com.api.tfg.service.guardia;

import com.api.tfg.entity.SituacionGuardia;
import java.util.List;

public interface ISituacionGuardiaService {
    SituacionGuardia findSituacionByGuardiaId(Long guardiaId);
    SituacionGuardia addSituacion(SituacionGuardia situacion);
    SituacionGuardia updateSituacion(Long id, SituacionGuardia newSituacion) throws Exception;
    boolean deleteSituacion(Long id) throws Exception;
}