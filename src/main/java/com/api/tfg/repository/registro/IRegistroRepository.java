package com.api.tfg.repository.registro;

import com.api.tfg.entity.Registro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRegistroRepository extends CrudRepository<Registro, Long> {
    Optional<Registro> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    List<Registro> findByPresentado(boolean presentado);
    List<Registro> findByValidado(boolean validado);
    List<Registro> findByPagado(boolean pagado);
}