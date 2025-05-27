package com.api.tfg.repository.apelacionguardia;

import com.api.tfg.entity.ApelacionGuardia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApelacionGuardiaRepository extends CrudRepository<ApelacionGuardia, Long> {
    List<ApelacionGuardia> findByGuardiaId(Long guardiaId);
    List<ApelacionGuardia> findByAdmitido(boolean admitido);
    List<ApelacionGuardia> findBySentencia(boolean sentencia);
}