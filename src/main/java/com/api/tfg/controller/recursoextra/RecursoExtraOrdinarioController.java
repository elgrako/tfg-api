package com.api.tfg.controller.recursoextra;

import com.api.tfg.dto.recursoextra.RecursoExtraOrdinarioDTO;
import com.api.tfg.entity.Guardia;
import com.api.tfg.entity.RecursoExtraOrdinario;
import com.api.tfg.mapper.Mapper;
import com.api.tfg.repository.guardia.IGuardiaRepository;
import com.api.tfg.service.recursoextra.IRecursoExtraOrdinarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/recursos-extraordinarios")
@Tag(name = "Recursos Extraordinarios", description = "Gestión de recursos extraordinarios")
public class RecursoExtraOrdinarioController {

    @Autowired
    private IRecursoExtraOrdinarioService recursoService;

    @Autowired
    private IGuardiaRepository guardiaRepository;

    @Autowired
    private Mapper mapper;

    @GetMapping("/guardia/{guardiaId}")
    @Operation(summary = "Obtener recursos extraordinarios por ID de guardia")
    public ResponseEntity<List<RecursoExtraOrdinarioDTO>> getByGuardiaId(@PathVariable Long guardiaId) {
        List<RecursoExtraOrdinario> recursos = recursoService.findAllByGuardiaId(guardiaId);
        return ResponseEntity.ok(mapper.mapList(recursos, RecursoExtraOrdinarioDTO.class));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo recurso extraordinario")
    public ResponseEntity<RecursoExtraOrdinarioDTO> create(@Valid @RequestBody RecursoExtraOrdinarioDTO dto) {
        Guardia guardia = guardiaRepository.findById(dto.getGuardiaId())
                .orElseThrow(() -> new RuntimeException("Guardia no encontrada con ID: " + dto.getGuardiaId()));

        RecursoExtraOrdinario recurso = new RecursoExtraOrdinario();
        recurso.setGuardia(guardia);
        recurso.setNExpediente(dto.getNExpediente());
        recurso.setAdmitido(dto.getAdmitido());

        RecursoExtraOrdinario creado = recursoService.createRecurso(recurso);
        return ResponseEntity.ok(mapper.mapType(creado, RecursoExtraOrdinarioDTO.class));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar recurso extraordinario")
    public ResponseEntity<RecursoExtraOrdinarioDTO> update(@PathVariable Long id, @Valid @RequestBody RecursoExtraOrdinarioDTO dto) {
        Guardia guardia = guardiaRepository.findById(dto.getGuardiaId())
                .orElseThrow(() -> new RuntimeException("Guardia no encontrada con ID: " + dto.getGuardiaId()));

        RecursoExtraOrdinario recurso = new RecursoExtraOrdinario();
        recurso.setId(id);
        recurso.setGuardia(guardia);
        recurso.setNExpediente(dto.getNExpediente());
        recurso.setAdmitido(dto.getAdmitido());

        RecursoExtraOrdinario actualizado = recursoService.updateRecurso(id, recurso);
        return ResponseEntity.ok(mapper.mapType(actualizado, RecursoExtraOrdinarioDTO.class));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar recurso extraordinario")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recursoService.deleteRecurso(id);
        return ResponseEntity.noContent().build();
    }
}
