package com.api.tfg.service.apelacionguardia;

import com.api.tfg.entity.ApelacionGuardia;
import java.util.List;

public interface IApelacionGuardiaService {
    List<ApelacionGuardia> findAllByGuardiaId(Long guardiaId);
    ApelacionGuardia findById(Long id);
    ApelacionGuardia createApelacion(ApelacionGuardia apelacion);
    ApelacionGuardia updateApelacion(Long id, ApelacionGuardia apelacion);
    boolean deleteApelacion(Long id);
    List<ApelacionGuardia> findByAdmitido(boolean admitido);
    List<ApelacionGuardia> findBySentencia(boolean sentencia);
}