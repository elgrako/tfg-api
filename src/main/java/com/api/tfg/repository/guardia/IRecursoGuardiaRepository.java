package com.api.tfg.repository.guardia;

import com.api.tfg.entity.RecursoGuardia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecursoGuardiaRepository extends CrudRepository<RecursoGuardia, Long> {
    List<RecursoGuardia> findByGuardiaId(Long guardiaId);
    List<RecursoGuardia> findByResuelto(boolean resuelto);
}