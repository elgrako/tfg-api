package com.api.tfg.repository.recursoextra;

import com.api.tfg.entity.RecursoExtraOrdinario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecursoExtraOrdinarioGuardiaRepository extends CrudRepository<RecursoExtraOrdinario, Long> {
    List<RecursoExtraOrdinario> findByGuardiaId(Long guardiaId);
    List<RecursoExtraOrdinario> findByAdmitido(boolean admitido);
}