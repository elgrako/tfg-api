package com.api.tfg.service.registro;

import com.api.tfg.entity.Registro;
import com.api.tfg.exception.ConflictException;
import com.api.tfg.exception.ResourceNotFoundException;
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
        return registroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro", id));
    }

    @Override
    public Registro findRegistroByNombre(String nombre) {
        return registroRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Registro con nombre", nombre));
    }

    @Override
    public Registro addRegistro(Registro registro) {
        if (registroRepository.existsByNombre(registro.getNombre())) {
            throw new ConflictException("Ya existe un registro con el nombre: " + registro.getNombre());
        }
        return registroRepository.save(registro);
    }

    @Override
    public Registro updateRegistro(Long id, Registro newRegistro) {
        Registro existing = registroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro", id));

        boolean nombreCambiado = !existing.getNombre().equals(newRegistro.getNombre());

        if (nombreCambiado && registroRepository.existsByNombre(newRegistro.getNombre())) {
            throw new ConflictException("Ya existe un registro con el nombre: " + newRegistro.getNombre());
        }

        newRegistro.setId(id);
        return registroRepository.save(newRegistro);
    }

    @Override
    public boolean deleteRegistro(Long id) {
        if (!registroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Registro", id);
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
