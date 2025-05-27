package com.api.tfg.service.recursoextra;

import com.api.tfg.entity.RecursoExtraOrdinario;
import java.util.List;

public interface IRecursoExtraOrdinarioService {
    List<RecursoExtraOrdinario> findAllByGuardiaId(Long guardiaId);
    RecursoExtraOrdinario findById(Long id);
    RecursoExtraOrdinario createRecurso(RecursoExtraOrdinario recurso);
    RecursoExtraOrdinario updateRecurso(Long id, RecursoExtraOrdinario recurso);
    boolean deleteRecurso(Long id);
    List<RecursoExtraOrdinario> findByAdmitido(boolean admitido);
}