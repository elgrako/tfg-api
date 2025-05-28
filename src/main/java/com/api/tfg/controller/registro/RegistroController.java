package com.api.tfg.controller.registro;

import com.api.tfg.dto.registro.RegistroDTO;
import com.api.tfg.entity.Registro;
import com.api.tfg.mapper.Mapper;
import com.api.tfg.service.registro.IRegistroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/registro")
@Tag(name = "Registros", description = "CRUD Registro")
public class RegistroController {

    private final Logger log = LoggerFactory.getLogger(RegistroController.class);

    @Autowired
    private IRegistroService registroService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/registros")
    @Operation(summary = "Obtener todos los registros")
    public ResponseEntity<List<RegistroDTO>> getAll() {
        List<Registro> registros = registroService.findAllRegistro();
        List<RegistroDTO> dtos = mapper.mapList(registros, RegistroDTO.class);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/registro/{id}")
    @Operation(summary = "Obtener registro por ID")
    public ResponseEntity<RegistroDTO> getOne(@PathVariable Long id) {
        Registro registro = registroService.findRegistroById(id);
        return ResponseEntity.ok(mapper.mapType(registro, RegistroDTO.class));
    }

    @PostMapping("/registro")
    @Operation(summary = "Crear un nuevo registro")
    public ResponseEntity<RegistroDTO> create(@Valid @RequestBody RegistroDTO dto) {
        Registro nuevo = mapper.mapType(dto, Registro.class);
        Registro guardado = registroService.addRegistro(nuevo);
        return ResponseEntity.ok(mapper.mapType(guardado, RegistroDTO.class));
    }

    @PutMapping("/actualizarRegistro/{id}")
    @Operation(summary = "Actualizar un registro")
    public ResponseEntity<RegistroDTO> update(@PathVariable Long id, @RequestBody Registro nuevo) {
        Registro actualizado = registroService.updateRegistro(id, nuevo);
        return ResponseEntity.ok(mapper.mapType(actualizado, RegistroDTO.class));
    }

    @DeleteMapping("/borrarRegistro/{id}")
    @Operation(summary = "Eliminar un registro")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        registroService.deleteRegistro(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/situacion1")
    @Operation(summary = "Obtener datos de situación1")
    public ResponseEntity<Map<String, Object>> getSituacion1(@PathVariable Long id) {
        Map<String, Object> situacion = registroService.getSituacion1(id);
        return ResponseEntity.ok(situacion);
    }

    @PatchMapping("/{id}/situacion1")
    @Operation(summary = "Actualizar datos de situación1")
    public ResponseEntity<Void> updateSituacion1(
            @PathVariable Long id,
            @RequestParam boolean presentado,
            @RequestParam boolean validado,
            @RequestParam boolean pagado,
            @RequestParam(required = false) Integer nTalon,
            @RequestParam(required = false) String comentarios) {

        registroService.updateSituacion1(
                id,
                presentado,
                validado,
                pagado,
                nTalon,
                comentarios
        );

        return ResponseEntity.noContent().build();
    }
}
