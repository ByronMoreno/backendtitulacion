package ec.yavirac.yavigestion.modules.administration.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.yavirac.yavigestion.modules.administration.dtos.request.user.CreateUserDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.request.user.UpdateUserDTO;
import ec.yavirac.yavigestion.modules.administration.dtos.request.user.UserDTO;
import ec.yavirac.yavigestion.modules.administration.services.facades.user.UserFacade;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericPaginationResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador REST para la gestión de usuarios del sistema.
 *
 * <p>Este controlador permite realizar operaciones CRUD sobre los usuarios,
 * tales como:
 * <ul>
 *   <li>Crear usuarios</li>
 *   <li>Listar usuarios de forma paginada</li>
 *   <li>Consultar un usuario por su identificador</li>
 *   <li>Actualizar información de un usuario</li>
 *   <li>Eliminar usuarios</li>
 * </ul>
 *
 * Los endpoints están disponibles bajo la ruta base <b>/users</b>.
 */
@Tag(
        name = "Usuarios",
        description = "Operaciones relacionadas con la gestión de usuarios"
)
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Fachada encargada de la lógica de negocio relacionada
     * con la administración de usuarios.
     */
    @Qualifier("userFacadeImpl")
    private final UserFacade userFacade;

    /**
     * Constructor del controlador de usuarios.
     *
     * @param userFacade implementación de la fachada de usuarios
     */
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    /**
     * Endpoint para crear un nuevo usuario en el sistema.
     *
     * @param userDTO objeto {@link CreateUserDTO} con la información
     *                necesaria para la creación del usuario
     * @return {@link ResponseEntity} con un mensaje de confirmación
     *         y el estado correspondiente de la operación
     */
    @Operation(
            summary = "Crear un usuario",
            description = "Ingresa un usuario"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PostMapping
    public ResponseEntity<GenericOnlyTextResponse> create(@RequestBody CreateUserDTO userDTO) {
        GenericOnlyTextResponse response = userFacade.save(userDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * Endpoint para obtener un listado paginado de usuarios.
     *
     * @param pageable información de paginación y ordenamiento
     * @return {@link ResponseEntity} con un listado paginado de usuarios
     */
    @Operation(
            summary = "Listar usuarios",
            description = "Obtiene un listado paginado de usuarios del sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
            @ApiResponse(responseCode = "404", description = "No se proceso la consulta")
    })
    @SecurityRequirement(name = "")
    @GetMapping
    public ResponseEntity<GenericPaginationResponse<UserDTO>> findAll(Pageable pageable) {
        GenericPaginationResponse<UserDTO> response = userFacade.findAll(pageable);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * Endpoint para obtener la información de un usuario
     * a partir de su identificador.
     *
     * @param id identificador único del usuario
     * @return {@link ResponseEntity} con la información del usuario
     */
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<UserDTO>> findOneById(@PathVariable Long id) {
        GenericResponse<UserDTO> period = userFacade.findById(id);
        return ResponseEntity.status(period.getStatus()).body(period);
    }

    /**
     * Endpoint para actualizar la información de un usuario existente.
     *
     * @param id identificador del usuario a actualizar
     * @param userDTO objeto {@link UpdateUserDTO} con los datos a modificar
     * @return {@link ResponseEntity} con un mensaje de confirmación
     */
    @PutMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateUserDTO userDTO) {

        GenericOnlyTextResponse response = userFacade.update(id, userDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * Endpoint para eliminar un usuario del sistema.
     *
     * @param id identificador del usuario a eliminar
     * @return {@link ResponseEntity} con un mensaje de confirmación
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericOnlyTextResponse> delete(@PathVariable Long id) {
        GenericOnlyTextResponse response = userFacade.delete(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}