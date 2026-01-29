package ec.yavirac.yavigestion.modules.auth.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Credenciales de autenticación del usuario")
public class AuthRequest {

    @Schema(
            description = "Correo electrónico del usuario",
            example = "usuario@test.com"
    )
    private String email;

    @Schema(
            description = "Contraseña del usuario",
            example = "P@ssw0rd123"
    )
    private String password;
}