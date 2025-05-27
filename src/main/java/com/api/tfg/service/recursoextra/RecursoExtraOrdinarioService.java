package com.api.tfg.service.recursoextra;

import com.api.tfg.entity.RecursoExtraOrdinario;
import com.api.tfg.repository.recursoextra.IRecursoExtraOrdinarioGuardiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecursoExtraOrdinarioService implements IRecursoExtraOrdinarioService {

    private final IRecursoExtraOrdinarioGuardiaRepository recursoRepository;

    @Autowired
    public RecursoExtraOrdinarioService(IRecursoExtraOrdinarioGuardiaRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Override
    public List<RecursoExtraOrdinario> findAllByGuardiaId(Long guardiaId) {
        return recursoRepository.findByGuardiaId(guardiaId);
    }

    @Override
    public RecursoExtraOrdinario findById(Long id) {
        return recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso Extraordinario no encontrado con ID: " + id));
    }

    @Override
    public RecursoExtraOrdinario createRecurso(RecursoExtraOrdinario recurso) {
        return recursoRepository.save(recurso);
    }

    @Override
    public RecursoExtraOrdinario updateRecurso(Long id, RecursoExtraOrdinario recurso) {
        if (!recursoRepository.existsById(id)) {
            throw new RuntimeException("Recurso Extraordinario no encontrado con ID: " + id);
        }
        recurso.setId(id);
        return recursoRepository.save(recurso);
    }

    @Override
    public boolean deleteRecurso(Long id) {
        if (!recursoRepository.existsById(id)) {
            throw new RuntimeException("Recurso Extraordinario no encontrado con ID: " + id);
        }
        recursoRepository.deleteById(id);
        return true;
    }

    @Override
    public List<RecursoExtraOrdinario> findByAdmitido(boolean admitido) {
        return recursoRepository.findByAdmitido(admitido);
    }
}