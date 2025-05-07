package com.api.tfg.repository.registro;

import com.api.tfg.entity.Registro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistroRepository extends CrudRepository<Registro, Long> {

}
