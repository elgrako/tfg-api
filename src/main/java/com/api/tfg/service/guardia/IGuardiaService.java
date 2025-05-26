package com.api.tfg.service.guardia;

import com.api.tfg.entity.Guardia;
import java.util.List;

public interface IGuardiaService {
    List<Guardia> findAllGuardias();
    Guardia findGuardiaById(Long id);
    Guardia addGuardia(Guardia guardia);
    Guardia updateGuardia(Long id, Guardia newGuardia) throws Exception;
    boolean deleteGuardia(Long id) throws Exception;
    List<Guardia> findByNombreAsistidoContaining(String nombre);
    List<Guardia> findByPorJuzgado(boolean porJuzgado);
    List<Guardia> findByCobrado(boolean cobrado);
}