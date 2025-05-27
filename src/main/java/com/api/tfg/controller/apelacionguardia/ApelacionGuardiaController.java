package com.api.tfg.controller.apelacionguardia;

import com.api.tfg.dto.apelacionguardia.ApelacionGuardiaDTO;
import com.api.tfg.entity.ApelacionGuardia;
import com.api.tfg.mapper.Mapper;
import com.api.tfg.service.apelacionguardia.IApelacionGuardiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apelaciones-guardia")
@Tag(name = "Apelaciones de Guardia", description = "Gestión de apelaciones relacionadas con guardias")
public class ApelacionGuardiaController {

    @Autowired
    private IApelacionGuardiaService apelacionService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/guardia/{guardiaId}")
    @Operation(summary = "Obtener apelaciones por ID de guardia")
    public ResponseEntity<List<ApelacionGuardiaDTO>> getByGuardiaId(@PathVariable Long guardiaId) {
        List<ApelacionGuardia> apelaciones = apelacionService.findAllByGuardiaId(guardiaId);
        return ResponseEntity.ok(mapper.mapList(apelaciones, ApelacionGuardiaDTO.class));
    }

    @PostMapping
    @Operation(summary = "Crear nueva apelación de guardia")
    public ResponseEntity<ApelacionGuardiaDTO> create(@Valid @RequestBody ApelacionGuardiaDTO dto) {
        ApelacionGuardia apelacion = mapper.mapType(dto, ApelacionGuardia.class);
        ApelacionGuardia creada = apelacionService.createApelacion(apelacion);
        return ResponseEntity.ok(mapper.mapType(creada, ApelacionGuardiaDTO.class));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar apelación de guardia")
    public ResponseEntity<ApelacionGuardiaDTO> update(@PathVariable Long id, @Valid @RequestBody ApelacionGuardiaDTO dto) {
        ApelacionGuardia apelacion = mapper.mapType(dto, ApelacionGuardia.class);
        ApelacionGuardia actualizada = apelacionService.updateApelacion(id, apelacion);
        return ResponseEntity.ok(mapper.mapType(actualizada, ApelacionGuardiaDTO.class));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar apelación de guardia")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        apelacionService.deleteApelacion(id);
        return ResponseEntity.noContent().build();
    }
}