package com.api.tfg.service.recursoguardia;

import com.api.tfg.entity.RecursoGuardia;
import java.util.List;

public interface IRecursoGuardiaService {
    List<RecursoGuardia> findAllByGuardiaId(Long guardiaId);
    RecursoGuardia findById(Long id);
    RecursoGuardia createRecurso(RecursoGuardia recurso);
    RecursoGuardia updateRecurso(Long id, RecursoGuardia recurso);
    boolean deleteRecurso(Long id);
    List<RecursoGuardia> findByResuelto(boolean resuelto);
}