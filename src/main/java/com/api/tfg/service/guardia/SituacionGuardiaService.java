package com.api.tfg.service.guardia;

import com.api.tfg.entity.SituacionGuardia;
import com.api.tfg.repository.guardia.ISituacionGuardiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SituacionGuardiaService implements ISituacionGuardiaService {

    @Autowired
    private ISituacionGuardiaRepository situacionRepository;

    @Override
    public SituacionGuardia findSituacionByGuardiaId(Long guardiaId) {
        return situacionRepository.findByGuardiaId(guardiaId).orElse(null);
    }

    @Override
    public SituacionGuardia addSituacion(SituacionGuardia situacion) {
        if (situacionRepository.existsById(situacion.getGuardia().getId())) {
            throw new IllegalArgumentException("Ya existe una situación para esta guardia");
        }
        return situacionRepository.save(situacion);
    }

    @Override
    public SituacionGuardia updateSituacion(Long id, SituacionGuardia newSituacion) throws Exception {
        situacionRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró la situación con el id: " + id));

        newSituacion.setId(id);
        return situacionRepository.save(newSituacion);
    }

    @Override
    public boolean deleteSituacion(Long id) throws Exception {
        if (!situacionRepository.existsById(id)) {
            throw new Exception("No se encontró la situación con el id: " + id);
        }
        situacionRepository.deleteById(id);
        return true;
    }
}