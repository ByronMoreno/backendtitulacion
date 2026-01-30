package ec.yavirac.yavigestion.modules.administration.controllers;

// Imports de Spring y Java
import ec.yavirac.yavigestion.modules.administration.dtos.request.domicilio.CreateDomicilioDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DomicilioResponseDto;
import ec.yavirac.yavigestion.modules.administration.services.facades.domicilio.DomicilioFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/domicilio")
@Tag(name = "Domicilio", description = "Gestión de domicilios con Capa Facade")
public class DomicilioController {

    @Autowired
    private DomicilioFacade domicilioFacade;

    @PostMapping("/insertar")
    @Operation(summary = "Crear domicilio", description = "Pasa por el Facade para orquestar la creación")
    public ResponseEntity<DomicilioResponseDto> crear(@RequestBody CreateDomicilioDto d) {
        return ResponseEntity.ok(domicilioFacade.guardar(d));
    }

    @GetMapping("/seleccionar")
    @Operation(summary = "Listar con paginación vía Facade")
    public ResponseEntity<Page<DomicilioResponseDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(domicilioFacade.listar(pageable));
    }
}