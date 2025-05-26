package com.api.tfg.service.registro;

import com.api.tfg.entity.Registro;
import com.api.tfg.repository.registro.IRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService implements IRegistroService {

    @Autowired
    private IRegistroRepository registroRepository;

    @Override
    public List<Registro> findAllRegistro() {
        return (List<Registro>) registroRepository.findAll();
    }

    @Override
    public Registro findRegistroById(Long id) {
        return registroRepository.findById(id).orElse(null);
    }

    @Override
    public Registro findRegistroByNombre(String nombre) {
        return registroRepository.findByNombre(nombre).orElse(null);
    }

    @Override
    public Registro addRegistro(Registro registro) {
        if (registroRepository.existsByNombre(registro.getNombre())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + registro.getNombre());
        }
        return registroRepository.save(registro);
    }

    @Override
    public Registro updateRegistro(Long id, Registro newRegistro) throws Exception {
        Registro existingRegistro = registroRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró el registro con el id: " + id));

        if (!existingRegistro.getNombre().equals(newRegistro.getNombre()) &&
                registroRepository.existsByNombre(newRegistro.getNombre())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + newRegistro.getNombre());
        }

        newRegistro.setId(id);
        return registroRepository.save(newRegistro);
    }

    @Override
    public boolean deleteRegistro(Long id) throws Exception {
        if (!registroRepository.existsById(id)) {
            throw new Exception("No se encontró el registro con el id: " + id);
        }
        registroRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Registro> findByPresentado(boolean presentado) {
        return registroRepository.findByPresentado(presentado);
    }

    @Override
    public List<Registro> findByValidado(boolean validado) {
        return registroRepository.findByValidado(validado);
    }

    @Override
    public List<Registro> findByPagado(boolean pagado) {
        return registroRepository.findByPagado(pagado);
    }
}