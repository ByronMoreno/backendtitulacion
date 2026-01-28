package ec.yavirac.yavigestion.modules.administration.dtos.request.user;

import ec.yavirac.yavigestion.modules.auth.dtos.request.PersonDto;
import ec.yavirac.yavigestion.modules.auth.entities.Role;

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
@Schema(description = "DTO para la actualización de un usuario")
public class UpdateUserDTO {

@Schema(
        description = "Correo electrónico del usuario",
        example = "usuario@yavirac.edu.ec"
)
private String email;

@Schema(
        description = "Fecha de creación del usuario",
        example = "2026-01-20T15:30:00Z"
)
private Instant createdAt;

@Schema(
        description = "Roles asignados al usuario"
)
private Set<Role> roles;

@Schema(
        description = "Información personal del usuario"
)
private PersonDto person;

@Schema(
        description = "Estado del usuario",
        example = "ACTIVE"
)
private String status;
}
