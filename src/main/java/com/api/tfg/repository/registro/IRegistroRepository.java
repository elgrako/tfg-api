package com.api.tfg.repository.registro;

import com.api.tfg.entity.Registro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface IRegistroRepository extends CrudRepository<Registro, Long> {
    Optional<Registro> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    List<Registro> findByPresentado(boolean presentado);
    List<Registro> findByValidado(boolean validado);
    List<Registro> findByPagado(boolean pagado);

    @Query(value = "SELECT presentado, validado, pagado, nTalon, comentarios FROM datos WHERE id = :id",
            nativeQuery = true)
    Optional<Map<String, Object>> findSituacion1ById(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE datos SET presentado = :presentado, validado = :validado, " +
            "pagado = :pagado, nTalon = :nTalon, comentarios = :comentarios " +
            "WHERE id = :id", nativeQuery = true)
    @Transactional
    void updateSituacion1(
            @Param("id") Long id,
            @Param("presentado") boolean presentado,
            @Param("validado") boolean validado,
            @Param("pagado") boolean pagado,
            @Param("nTalon") Integer nTalon,
            @Param("comentarios") String comentarios);

}