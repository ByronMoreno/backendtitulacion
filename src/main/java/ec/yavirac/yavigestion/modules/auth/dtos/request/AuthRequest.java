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

// ===== DOCUMENTACIÓN DEL DTO =====
@Schema(
        name = "AuthRequest",
        description = "DTO utilizado para el inicio de sesión del usuario en el sistema"
)
public class AuthRequest {

    // ===== EMAIL DEL USUARIO =====
    @Schema(
            description = "Correo electrónico del usuario",
            example = "usuario@yavirac.edu.ec",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String email;

    // ===== CONTRASEÑA DEL USUARIO =====
    @Schema(
            description = "Contraseña del usuario",
            example = "123456",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String password;
}
