package com.api.tfg.service.apelacionguardia;

import com.api.tfg.entity.ApelacionGuardia;
import com.api.tfg.repository.apelacionguardia.IApelacionGuardiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApelacionGuardiaService implements IApelacionGuardiaService {

    private final IApelacionGuardiaRepository apelacionRepository;

    @Autowired
    public ApelacionGuardiaService(IApelacionGuardiaRepository apelacionRepository) {
        this.apelacionRepository = apelacionRepository;
    }

    @Override
    public List<ApelacionGuardia> findAllByGuardiaId(Long guardiaId) {
        return apelacionRepository.findByGuardiaId(guardiaId);
    }

    @Override
    public ApelacionGuardia findById(Long id) {
        return apelacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apelación no encontrada con ID: " + id));
    }

    @Override
    public ApelacionGuardia createApelacion(ApelacionGuardia apelacion) {
        return apelacionRepository.save(apelacion);
    }

    @Override
    public ApelacionGuardia updateApelacion(Long id, ApelacionGuardia apelacion) {
        if (!apelacionRepository.existsById(id)) {
            throw new RuntimeException("Apelación no encontrada con ID: " + id);
        }
        apelacion.setId(id);
        return apelacionRepository.save(apelacion);
    }

    @Override
    public boolean deleteApelacion(Long id) {
        if (!apelacionRepository.existsById(id)) {
            throw new RuntimeException("Apelación no encontrada con ID: " + id);
        }
        apelacionRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ApelacionGuardia> findByAdmitido(boolean admitido) {
        return apelacionRepository.findByAdmitido(admitido);
    }

    @Override
    public List<ApelacionGuardia> findBySentencia(boolean sentencia) {
        return apelacionRepository.findBySentencia(sentencia);
    }
}