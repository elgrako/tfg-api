package com.api.tfg.service.registro;

import com.api.tfg.entity.Registro;
import com.api.tfg.repository.registro.IRegistroRepository;
import com.api.tfg.service.registro.IRegistroService;
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
    public Registro addRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    @Override
    public Registro updateRegistro(Long id, Registro newRegistro) throws Exception {
        registroRepository.findById(id).orElseThrow(() ->
                new Exception("No se encontro el registro con el id: " + id));

        newRegistro.setId(id);
        return registroRepository.save(newRegistro);
    }

    @Override
    public boolean deleteRegistro(Long id) throws Exception {
        registroRepository.findById(id).orElseThrow(() ->
                new Exception("No se encontro el registro con el id: " + id));
        registroRepository.deleteById(id);
        return true;
    }
}
