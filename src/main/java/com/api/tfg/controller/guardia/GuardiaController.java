package com.api.tfg.controller.guardia;

import com.api.tfg.dto.guardia.GuardiaDTO;
import com.api.tfg.entity.Guardia;
import com.api.tfg.mapper.Mapper;
import com.api.tfg.service.guardia.IGuardiaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/guardias")
@Tag(name = "Guardias", description = "Operaciones relacionadas con guardias")
public class GuardiaController {

    private final Logger log = LoggerFactory.getLogger(GuardiaController.class);

    @Autowired
    private IGuardiaService guardiaService;

    @Autowired
    private Mapper mapper;

    @GetMapping
    @Operation(summary = "Obtener todas las guardias")
    public ResponseEntity<List<GuardiaDTO>> getAll() {
        List<Guardia> guardias = guardiaService.findAllGuardias();
        List<GuardiaDTO> dtos = mapper.mapList(guardias, GuardiaDTO.class);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener guardia por ID")
    public ResponseEntity<GuardiaDTO> getById(@PathVariable Long id) {
        Guardia guardia = guardiaService.findGuardiaById(id);
        return ResponseEntity.ok(mapper.mapType(guardia, GuardiaDTO.class));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva guardia")
    public ResponseEntity<GuardiaDTO> create(@Valid @RequestBody GuardiaDTO dto) {
        Guardia guardia = mapper.mapType(dto, Guardia.class);
        Guardia guardiaCreada = guardiaService.addGuardia(guardia);
        return ResponseEntity.ok(mapper.mapType(guardiaCreada, GuardiaDTO.class));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una guardia")
    public ResponseEntity<GuardiaDTO> update(@PathVariable Long id, @Valid @RequestBody GuardiaDTO dto) {
        Guardia guardia = mapper.mapType(dto, Guardia.class);
        Guardia guardiaActualizada = guardiaService.updateGuardia(id, guardia);
        return ResponseEntity.ok(mapper.mapType(guardiaActualizada, GuardiaDTO.class));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una guardia")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guardiaService.deleteGuardia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/por-juzgado/{porJuzgado}")
    @Operation(summary = "Filtrar guardias por juzgado")
    public ResponseEntity<List<GuardiaDTO>> findByPorJuzgado(@PathVariable boolean porJuzgado) {
        List<Guardia> guardias = guardiaService.findByPorJuzgado(porJuzgado);
        List<GuardiaDTO> dtos = mapper.mapList(guardias, GuardiaDTO.class);
        return ResponseEntity.ok(dtos);
    }
}
