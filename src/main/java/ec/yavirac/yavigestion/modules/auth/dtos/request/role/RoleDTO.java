package ec.yavirac.yavigestion.modules.auth.dtos.request.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "Información básica de un rol dentro del sistema")
public class RoleDTO {

    @Schema(
            description = "Identificador único del rol",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Nombre del rol",
            example = "ADMIN"
    )
    private String name;

    @Schema(
            description = "Descripción del rol y sus responsabilidades",
            example = "Rol con acceso total al sistema"
    )
    private String description;

    @Schema(
            description = "Estado del rol dentro del sistema",
            example = "ACTIVE",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String status;
}
