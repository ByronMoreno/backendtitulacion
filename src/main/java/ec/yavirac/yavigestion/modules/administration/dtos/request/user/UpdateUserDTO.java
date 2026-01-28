package ec.yavirac.yavigestion.modules.administration.dtos.request.user;

import ec.yavirac.yavigestion.modules.auth.dtos.request.PersonDto;
import ec.yavirac.yavigestion.modules.auth.entities.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Builder
@Schema(description = "DTO para la actualización de información de usuario")
public class UpdateUserDTO {

    @Schema(description = "Correo electrónico institucional o personal", example = "usuario@yavirac.edu.ec")
    private String email;

    @Schema(description = "Fecha de creación del registro (Solo lectura)", accessMode = Schema.AccessMode.READ_ONLY)
    private Instant createdAt;

    @Schema(description = "Listado de roles asignados al usuario")
    private Set<Role> roles;

    @Schema(description = "Objeto con la información personal detallada (Nombres, Cédula, etc.)")
    private PersonDto person;

    @Schema(description = "Estado actual del usuario en el sistema", allowableValues = {"ACTIVE", "INACTIVE", "BLOCKED"})
    private String status;
}