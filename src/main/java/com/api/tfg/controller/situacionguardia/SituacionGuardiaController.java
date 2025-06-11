package com.api.tfg.controller.situacionguardia;

import com.api.tfg.dto.situacionguardia.SituacionGuardiaDTO;
import com.api.tfg.entity.Guardia;
import com.api.tfg.entity.SituacionGuardia;
import com.api.tfg.mapper.Mapper;
import com.api.tfg.service.situacionguardia.ISituacionGuardiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/situaciones-guardia")
@Tag(name = "Situaciones de Guardia", description = "Gestión de situaciones relacionadas con guardias")
public class SituacionGuardiaController {

    @Autowired
    private ISituacionGuardiaService situacionService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/guardia/{guardiaId}")
    @Operation(summary = "Obtener situación por ID de guardia")
    public ResponseEntity<SituacionGuardiaDTO> getByGuardiaId(@PathVariable Long guardiaId) {
        Optional<SituacionGuardia> situacion = situacionService.findByGuardiaId(guardiaId);
        return situacion
                .map(value -> ResponseEntity.ok(mapper.mapType(value, SituacionGuardiaDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nueva situación de guardia")
    public ResponseEntity<SituacionGuardiaDTO> create(@Valid @RequestBody SituacionGuardiaDTO dto) {
        SituacionGuardia situacion = mapper.mapType(dto, SituacionGuardia.class);

        Guardia guardia = new Guardia();
        guardia.setId(dto.getGuardiaId());
        situacion.setGuardia(guardia);

        SituacionGuardia creada = situacionService.createSituacion(situacion);
        return ResponseEntity.ok(mapper.mapType(creada, SituacionGuardiaDTO.class));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar situación de guardia")
    public ResponseEntity<SituacionGuardiaDTO> update(@PathVariable Long id, @Valid @RequestBody SituacionGuardiaDTO dto) {
        SituacionGuardia situacion = mapper.mapType(dto, SituacionGuardia.class);

        Guardia guardia = new Guardia();
        guardia.setId(dto.getGuardiaId());
        situacion.setGuardia(guardia);

        SituacionGuardia actualizada = situacionService.updateSituacion(id, situacion);
        return ResponseEntity.ok(mapper.mapType(actualizada, SituacionGuardiaDTO.class));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar situación de guardia")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        situacionService.deleteSituacion(id);
        return ResponseEntity.noContent().build();
    }
}
