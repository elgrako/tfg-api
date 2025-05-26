package com.api.tfg.service.guardia;

import com.api.tfg.entity.Guardia;
import com.api.tfg.repository.guardia.IGuardiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardiaService implements IGuardiaService {

    @Autowired
    private IGuardiaRepository guardiaRepository;

    @Override
    public List<Guardia> findAllGuardias() {
        return (List<Guardia>) guardiaRepository.findAll();
    }

    @Override
    public Guardia findGuardiaById(Long id) {
        return guardiaRepository.findById(id).orElse(null);
    }

    @Override
    public Guardia addGuardia(Guardia guardia) {
        return guardiaRepository.save(guardia);
    }

    @Override
    public Guardia updateGuardia(Long id, Guardia newGuardia) throws Exception {
        guardiaRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró la guardia con el id: " + id));

        newGuardia.setId(id);
        return guardiaRepository.save(newGuardia);
    }

    @Override
    public boolean deleteGuardia(Long id) throws Exception {
        if (!guardiaRepository.existsById(id)) {
            throw new Exception("No se encontró la guardia con el id: " + id);
        }
        guardiaRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Guardia> findByNombreAsistidoContaining(String nombre) {
        return guardiaRepository.findByNombreAsistidoContaining(nombre);
    }

    @Override
    public List<Guardia> findByPorJuzgado(boolean porJuzgado) {
        return guardiaRepository.findByPorJuzgado(porJuzgado);
    }

    @Override
    public List<Guardia> findByCobrado(boolean cobrado) {
        return guardiaRepository.findByCobrado(cobrado);
    }
}