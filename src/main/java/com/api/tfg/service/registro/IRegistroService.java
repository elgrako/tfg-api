package com.api.tfg.service.registro;

import com.api.tfg.entity.Registro;
import java.util.List;

public interface IRegistroService {
    List<Registro> findAllRegistro();
    Registro findRegistroById(Long id);
    Registro findRegistroByNombre(String nombre);
    Registro addRegistro(Registro registro);
    Registro updateRegistro(Long id, Registro newRegistro) throws Exception;
    boolean deleteRegistro(Long id) throws Exception;
    List<Registro> findByPresentado(boolean presentado);
    List<Registro> findByValidado(boolean validado);
    List<Registro> findByPagado(boolean pagado);
}