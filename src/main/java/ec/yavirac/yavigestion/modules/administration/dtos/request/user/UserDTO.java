package ec.yavirac.yavigestion.modules.administration.dtos.request.user;

import ec.yavirac.yavigestion.modules.auth.dtos.request.PersonDto;
import ec.yavirac.yavigestion.modules.auth.dtos.request.role.RoleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Builder
@Schema(description = "DTO que representa la información pública y administrativa de un usuario")
public class UserDTO {

    @Schema(description = "Identificador único del usuario", example = "1")
    private Long id;

    @Schema(description = "Correo electrónico institucional", example = "marlon.estudiante@yavirac.edu.ec")
    private String email;

    @Schema(description = "Fecha y hora de creación del usuario", example = "2026-01-28T13:45:00Z")
    private Instant createdAt;

    @Schema(description = "Conjunto de roles asignados para el control de acceso (RBAC)")
    private Set<RoleDTO> roles;

    @Schema(description = "Información biográfica y personal vinculada al usuario")
    private PersonDto person;

    @Schema(description = "Estado operativo del usuario", allowableValues = {"ACTIVE", "INACTIVE", "LOCKED"})
    private String status;
}