package com.api.tfg.controller.recursoguardia;

import com.api.tfg.dto.recursoguardia.RecursoGuardiaDTO;
import com.api.tfg.entity.Guardia;
import com.api.tfg.entity.RecursoGuardia;
import com.api.tfg.mapper.Mapper;
import com.api.tfg.repository.guardia.IGuardiaRepository;
import com.api.tfg.service.recursoguardia.IRecursoGuardiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/recursos-guardia")
@Tag(name = "Recursos de Guardia", description = "Gestión de recursos relacionados con guardias")
public class RecursoGuardiaController {

    @Autowired
    private IRecursoGuardiaService recursoService;

    @Autowired
    private IGuardiaRepository guardiaRepository;

    @Autowired
    private Mapper mapper;

    @GetMapping("/guardia/{guardiaId}")
    @Operation(summary = "Obtener recursos por ID de guardia")
    public ResponseEntity<List<RecursoGuardiaDTO>> getByGuardiaId(@PathVariable Long guardiaId) {
        List<RecursoGuardia> recursos = recursoService.findAllByGuardiaId(guardiaId);
        return ResponseEntity.ok(mapper.mapList(recursos, RecursoGuardiaDTO.class));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo recurso de guardia")
    public ResponseEntity<RecursoGuardiaDTO> create(@Valid @RequestBody RecursoGuardiaDTO dto) {
        Guardia guardia = guardiaRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Guardia no encontrada con ID: " + dto.getId()));

        RecursoGuardia recurso = new RecursoGuardia();
        recurso.setGuardia(guardia);
        recurso.setNExpediente(dto.getNExpediente());
        recurso.setResuelto(dto.getResuelto());

        RecursoGuardia creado = recursoService.createRecurso(recurso);
        return ResponseEntity.ok(mapper.mapType(creado, RecursoGuardiaDTO.class));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar recurso de guardia")
    public ResponseEntity<RecursoGuardiaDTO> update(@PathVariable Long id, @Valid @RequestBody RecursoGuardiaDTO dto) {
        Guardia guardia = guardiaRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Guardia no encontrada con ID: " + dto.getId()));

        RecursoGuardia recurso = new RecursoGuardia();
        recurso.setId(id);
        recurso.setGuardia(guardia);
        recurso.setNExpediente(dto.getNExpediente());
        recurso.setResuelto(dto.getResuelto());

        RecursoGuardia actualizado = recursoService.updateRecurso(id, recurso);
        return ResponseEntity.ok(mapper.mapType(actualizado, RecursoGuardiaDTO.class));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar recurso de guardia")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recursoService.deleteRecurso(id);
        return ResponseEntity.noContent().build();
    }
}
