package ec.yavirac.yavigestion.modules.administration.controllers;

import ec.yavirac.yavigestion.modules.administration.dtos.request.domicilio.CreateDomicilioDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DomicilioResponseDto;
import ec.yavirac.yavigestion.modules.administration.services.database.domicilio.DomicilioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/domicilio")
@Tag(name = "Domicilio", description = "Gestión de domicilios con DTOs y Paginación")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping("/insertar")
    @Operation(summary = "Crear domicilio", description = "Usa CreateDomicilioDto para enviar los datos")
    public ResponseEntity<DomicilioResponseDto> crear(@RequestBody CreateDomicilioDto d) {
        // El servicio ahora se encarga de recibir el DTO y devolver el ResponseDTO
        return ResponseEntity.ok(domicilioService.save(d));
    }

    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping("/seleccionar")
    @Operation(summary = "Listar con paginación manual")
    public ResponseEntity<Page<DomicilioResponseDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<DomicilioResponseDto> response = domicilioService.findAll(pageable);
        return ResponseEntity.ok(response);
    }
}