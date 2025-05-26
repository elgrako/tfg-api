package com.api.tfg.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        if (registro == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.mapType(registro, RegistroDTO.class));
    }

    @PostMapping("/registro")
    @Operation(summary = "Crear un nuevo registro")
    public ResponseEntity<RegistroDTO> create(@Valid @RequestBody CrearRegistroDTO dto) {
        Registro nuevo = mapper.mapType(dto, Registro.class);
        Registro guardado = registroService.addRegistro(nuevo);
        return ResponseEntity.ok(mapper.mapType(guardado, RegistroDTO.class));
    }

    @PutMapping("/actualizarRegistro/{id}")
    @Operation(summary = "Actualizar un registro")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Registro nuevo) {
        Map<String, Object> response = new HashMap<>();
        try {
            Registro actualizado = registroService.updateRegistro(id, nuevo);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            log.error("Error actualizando registro", e);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/borrarRegistro/{id}")
    @Operation(summary = "Eliminar un registro")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            registroService.deleteRegistro(id);
            response.put("mensaje", "Registro eliminado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error eliminando el registro", e);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
