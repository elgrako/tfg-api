package com.api.tfg.repository.guardia;

import com.api.tfg.entity.Guardia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGuardiaRepository extends CrudRepository<Guardia, Long> {
    List<Guardia> findByNombreAsistidoContaining(String nombre);
    List<Guardia> findByPorJuzgado(boolean porJuzgado);
    List<Guardia> findByCobrado(boolean cobrado);
}