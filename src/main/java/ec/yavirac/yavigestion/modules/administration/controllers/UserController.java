package ec.yavirac.yavigestion.modules.administration.controllers;

import ec.yavirac.yavigestion.modules.administration.dtos.request.user.CreateUserDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.request.user.UpdateUserDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.request.user.UserDTO;
import ec.yavirac.yavigestion.modules.administration.services.facades.user.UserFacade;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericPaginationResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericResponse;

// ===== IMPORT DE SWAGGER PARA DOCUMENTAR ENDPOINTS =====
import io.swagger.v3.oas.annotations.Operation;           // Para resumir y describir cada endpoint
import io.swagger.v3.oas.annotations.responses.ApiResponse; // Define respuesta HTTP individual
import io.swagger.v3.oas.annotations.responses.ApiResponses; // Agrupa varias respuestas
import io.swagger.v3.oas.annotations.security.SecurityRequirement; // Para indicar seguridad (JWT)
import io.swagger.v3.oas.annotations.tags.Tag;            // Para agrupar endpoints en Swagger

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// ===== DOCUMENTACIÓN DEL CONTROLADOR =====
// @Tag agrupa todos los endpoints bajo "Usuarios" en Swagger
@Tag(
        name = "Usuarios",
        description = "Operaciones relacionadas con la gestión de usuarios del sistema"
)
@RestController
@RequestMapping("/users")
// Indica que este controlador requiere autenticación JWT
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Qualifier("userFacadeImpl")
    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    // ===== DOCUMENTACIÓN DEL ENDPOINT CREATE =====
    @Operation(
            summary = "Crear usuario",                 // Qué hace
            description = "Crea un nuevo usuario en el sistema"
    )
    @ApiResponses({                                   // Posibles respuestas
            @ApiResponse(responseCode = "201", description = "Usuario creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<GenericOnlyTextResponse> create(@RequestBody CreateUserDTO userDTO) {
        GenericOnlyTextResponse response = userFacade.save(userDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // ===== DOCUMENTACIÓN DEL ENDPOINT FIND ALL =====
    @Operation(
            summary = "Listar usuarios",
            description = "Obtiene un listado paginado de usuarios"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa")
    })
    @GetMapping
    public ResponseEntity<GenericPaginationResponse<UserDTO>> findAll(Pageable pageable) {
        GenericPaginationResponse<UserDTO> response = userFacade.findAll(pageable);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // ===== DOCUMENTACIÓN DEL ENDPOINT FIND BY ID =====
    @Operation(
            summary = "Buscar usuario por ID",
            description = "Obtiene la información de un usuario específico"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<UserDTO>> findOneById(@PathVariable Long id) {
        GenericResponse<UserDTO> response = userFacade.findById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // ===== DOCUMENTACIÓN DEL ENDPOINT UPDATE =====
    @Operation(
            summary = "Actualizar usuario",
            description = "Actualiza la información de un usuario existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateUserDTO userDTO
    ) {
        GenericOnlyTextResponse response = userFacade.update(id, userDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // ===== DOCUMENTACIÓN DEL ENDPOINT DELETE =====
    @Operation(
            summary = "Eliminar usuario",
            description = "Elimina un usuario del sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> delete(@PathVariable Long id) {
        GenericOnlyTextResponse response = userFacade.delete(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}