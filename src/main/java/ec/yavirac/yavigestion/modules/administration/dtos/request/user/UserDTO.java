package ec.yavirac.yavigestion.modules.administration.dtos.request.user;

import ec.yavirac.yavigestion.modules.auth.dtos.request.PersonDto;
import ec.yavirac.yavigestion.modules.auth.dtos.request.role.RoleDTO;

// ===== IMPORT DE SWAGGER PARA DOCUMENTAR EL DTO =====
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Builder

// ===== DOCUMENTACIÓN DEL DTO CON SWAGGER =====
// @Schema describe la clase UserDTO para la documentación de la API
@Schema(description = "DTO de respuesta con la información del usuario")
public class UserDTO {

    // ===== DOCUMENTACIÓN DEL CAMPO id =====
    @Schema(
            description = "Identificador único del usuario",
            example = "1"
    )
    private Long id;

    // ===== DOCUMENTACIÓN DEL CAMPO email =====
    @Schema(
            description = "Correo electrónico del usuario",
            example = "usuario@yavirac.edu.ec"
    )
    private String email;

    // ===== DOCUMENTACIÓN DEL CAMPO createdAt =====
    @Schema(
            description = "Fecha de creación del usuario",
            example = "2026-01-20T15:30:00Z"
    )
    private Instant createdAt;

    // ===== DOCUMENTACIÓN DEL CAMPO roles =====
    @Schema(
            description = "Roles asignados al usuario"
    )
    private Set<RoleDTO> roles;

    // ===== DOCUMENTACIÓN DEL CAMPO person =====
    @Schema(
            description = "Información personal del usuario"
    )
    private PersonDto person;

    // ===== DOCUMENTACIÓN DEL CAMPO status =====
    @Schema(
            description = "Estado del usuario",
            example = "ACTIVE"
    )
    private String status;
}
