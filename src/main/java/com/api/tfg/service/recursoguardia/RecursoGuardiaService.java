package com.api.tfg.service.recursoguardia;

import com.api.tfg.entity.RecursoGuardia;
import com.api.tfg.repository.recursoguardia.IRecursoGuardiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecursoGuardiaService implements IRecursoGuardiaService {

    private final IRecursoGuardiaRepository recursoRepository;

    @Autowired
    public RecursoGuardiaService(IRecursoGuardiaRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Override
    public List<RecursoGuardia> findAllByGuardiaId(Long guardiaId) {
        return recursoRepository.findByGuardiaId(guardiaId);
    }

    @Override
    public RecursoGuardia findById(Long id) {
        return recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso no encontrado con ID: " + id));
    }

    @Override
    public RecursoGuardia createRecurso(RecursoGuardia recurso) {
        return recursoRepository.save(recurso);
    }

    @Override
    public RecursoGuardia updateRecurso(Long id, RecursoGuardia recurso) {
        if (!recursoRepository.existsById(id)) {
            throw new RuntimeException("Recurso no encontrado con ID: " + id);
        }
        recurso.setId(id);
        return recursoRepository.save(recurso);
    }

    @Override
    public boolean deleteRecurso(Long id) {
        if (!recursoRepository.existsById(id)) {
            throw new RuntimeException("Recurso no encontrado con ID: " + id);
        }
        recursoRepository.deleteById(id);
        return true;
    }

    @Override
    public List<RecursoGuardia> findByResuelto(boolean resuelto) {
        return recursoRepository.findByResuelto(resuelto);
    }
}