package ec.yavirac.yavigestion.modules.auth.dtos.request.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

// ===== DOCUMENTACIÓN DEL DTO =====
@Schema(
        name = "RoleDTO",
        description = "DTO que representa un rol del sistema de autenticación"
)
public class RoleDTO {

    // ===== ID DEL ROL =====
    @Schema(
            description = "Identificador único del rol",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    // ===== NOMBRE DEL ROL =====
    @Schema(
            description = "Nombre del rol",
            example = "ADMIN"
    )
    private String name;

    // ===== DESCRIPCIÓN DEL ROL =====
    @Schema(
            description = "Descripción del rol y sus responsabilidades",
            example = "Rol con permisos administrativos"
    )
    private String description;

    // ===== ESTADO DEL ROL =====
    @Schema(
            description = "Estado actual del rol",
            example = "ACTIVE",
            allowableValues = {"ACTIVE", "INACTIVE"},
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String status;
}
