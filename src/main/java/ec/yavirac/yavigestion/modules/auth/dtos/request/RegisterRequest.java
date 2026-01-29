package ec.yavirac.yavigestion.modules.auth.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "Datos necesarios para el registro de un nuevo usuario")
public class RegisterRequest {

    @Schema(
            description = "Nombres del usuario",
            example = "Juan"
    )
    private String firstName;

    @Schema(
            description = "Apellidos del usuario",
            example = "Pérez"
    )
    private String lastName;

    @Schema(
            description = "Correo electrónico del usuario",
            example = "juan@test.com"
    )
    private String email;

    @Schema(
            description = "Contraseña del usuario",
            example = "P@ssw0rd123"
    )
    private String password;

    @Schema(
            description = "Confirmación de la contraseña",
            example = "P@ssw0rd123"
    )
    private String confirmPassword;
}