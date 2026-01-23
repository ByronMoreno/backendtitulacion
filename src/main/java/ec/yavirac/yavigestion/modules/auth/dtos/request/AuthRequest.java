package ec.yavirac.yavigestion.modules.auth.dtos.request;

// ===== IMPORT DE SWAGGER PARA DOCUMENTAR EL DTO =====
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// ===== DOCUMENTACIÓN DEL DTO CON SWAGGER =====
// @Schema indica que esta clase será visible en la documentación de Swagger
@Schema(
    name = "AuthRequest",                                  // Nombre del DTO en Swagger
    description = "DTO utilizado para el inicio de sesión del usuario"  // Qué representa
)
public class AuthRequest {

    // ===== DOCUMENTACIÓN DEL CAMPO EMAIL =====
    @Schema(
        description = "Correo electrónico del usuario",    // Qué representa
        example = "usuario@yavirac.edu.ec",               // Ejemplo mostrado en Swagger
        requiredMode = Schema.RequiredMode.REQUIRED      // Campo obligatorio
    )
    private String email;

    // ===== DOCUMENTACIÓN DEL CAMPO PASSWORD =====
    @Schema(
        description = "Contraseña del usuario",           // Qué representa
        example = "123456",                                // Ejemplo para la documentación
        requiredMode = Schema.RequiredMode.REQUIRED      // Campo obligatorio
    )
    private String password;
}