package com.api.tfg.service.situacionguardia;

import com.api.tfg.entity.SituacionGuardia;
import com.api.tfg.repository.situacionguardia.ISituacionGuardiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SituacionGuardiaService implements ISituacionGuardiaService {

    private final ISituacionGuardiaRepository situacionRepository;

    @Autowired
    public SituacionGuardiaService(ISituacionGuardiaRepository situacionRepository) {
        this.situacionRepository = situacionRepository;
    }

    @Override
    public Optional<SituacionGuardia> findByGuardiaId(Long guardiaId) {
        return situacionRepository.findByGuardiaId(guardiaId);
    }

    @Override
    public SituacionGuardia createSituacion(SituacionGuardia situacion) {
        if (situacionRepository.existsById(situacion.getGuardia().getId())) {
            throw new RuntimeException("Ya existe una situación para esta guardia");
        }
        return situacionRepository.save(situacion);
    }

    @Override
    public SituacionGuardia updateSituacion(Long id, SituacionGuardia situacion) {
        if (!situacionRepository.existsById(id)) {
            throw new RuntimeException("Situación no encontrada con ID: " + id);
        }
        situacion.setId(id);
        return situacionRepository.save(situacion);
    }

    @Override
    public boolean deleteSituacion(Long id) {
        if (!situacionRepository.existsById(id)) {
            throw new RuntimeException("Situación no encontrada con ID: " + id);
        }
        situacionRepository.deleteById(id);
        return true;
    }
}