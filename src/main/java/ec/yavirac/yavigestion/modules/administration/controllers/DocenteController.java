package ec.yavirac.yavigestion.modules.administration.controllers;

import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.CreateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.UpdateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DocenteDto;
import ec.yavirac.yavigestion.modules.administration.services.facades.docente.DocenteFacade;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docentes")
@RequiredArgsConstructor
@Tag(
    name = "Docentes",
    description = "Endpoints para la gestión de docentes"
)
public class DocenteController {

    private final DocenteFacade docenteFacade;

    @Operation(
        summary = "Crear un docente",
        description = "Registra un nuevo docente"
    )
    @ApiResponse(responseCode = "201", description = "Docente creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @PostMapping
    public ResponseEntity<DocenteDto> createDocente(
            @RequestBody CreateDocenteDto createDocenteDto) {

        return ResponseEntity.ok(
                docenteFacade.create(createDocenteDto)
        );
    }

    @Operation(
        summary = "Listar docentes",
        description = "Obtiene un listado de docentes"
    )
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping
    public ResponseEntity<List<DocenteDto>> getAllDocentes() {
        return ResponseEntity.ok(docenteFacade.findAll());
    }

    @Operation(
        summary = "Buscar docente por ID",
        description = "Obtiene un docente específico por su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Docente encontrado")
    @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<DocenteDto> getDocenteById(
            @Parameter(description = "ID del docente", example = "1")
            @PathVariable Long id) {

        return ResponseEntity.ok(docenteFacade.findById(id));
    }

    @Operation(
        summary = "Actualizar docente",
        description = "Actualiza la información de un docente existente"
    )
    @ApiResponse(responseCode = "200", description = "Docente actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<DocenteDto> updateDocente(
            @PathVariable Long id,
            @RequestBody UpdateDocenteDto updateDocenteDto) {

        return ResponseEntity.ok(
                docenteFacade.update(id, updateDocenteDto)
        );
    }

    @Operation(
        summary = "Eliminar docente",
        description = "Elimina un docente por su ID"
    )
    @ApiResponse(responseCode = "204", description = "Docente eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(
            @Parameter(description = "ID del docente", example = "1")
            @PathVariable Long id) {

        docenteFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
