package ec.yavirac.yavigestion.modules.auth.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

// ===== DOCUMENTACIÓN DEL DTO =====
@Schema(
        name = "RegisterRequest",
        description = "Datos necesarios para registrar un nuevo usuario en el sistema"
)
public class RegisterRequest {

    @Schema(
            description = "Nombres del usuario",
            example = "Juan Carlos",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String firstName;

    @Schema(
            description = "Apellidos del usuario",
            example = "Pérez Gómez",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String lastName;

    @Schema(
            description = "Correo electrónico del usuario",
            example = "juan.perez@yavirac.edu.ec",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String email;

    @Schema(
            description = "Contraseña del usuario",
            example = "123456",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String password;

    @Schema(
            description = "Confirmación de la contraseña",
            example = "123456",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String confirmPassword;
}