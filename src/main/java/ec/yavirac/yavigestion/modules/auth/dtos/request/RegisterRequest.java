package ec.yavirac.yavigestion.modules.auth.dtos.request;

// ===== IMPORT DE SWAGGER PARA DOCUMENTAR EL DTO =====
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

// ===== DOCUMENTACIÓN DEL DTO CON SWAGGER =====
// @Schema define el DTO en la documentación, nombre y descripción
@Schema(
    name = "RegisterRequest",                                        // Nombre del DTO en Swagger
    description = "Datos necesarios para registrar un nuevo usuario en el sistema"  // Qué representa
)
public class RegisterRequest {

    // ===== DOCUMENTACIÓN DEL CAMPO firstName =====
    @Schema(
        description = "Nombres del usuario",                          // Qué representa
        example = "Juan Carlos",                                      // Ejemplo mostrado en Swagger
        requiredMode = Schema.RequiredMode.REQUIRED                  // Campo obligatorio
    )
    private String firstName;

    // ===== DOCUMENTACIÓN DEL CAMPO lastName =====
    @Schema(
        description = "Apellidos del usuario",
        example = "Pérez Gómez",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String lastName;

    // ===== DOCUMENTACIÓN DEL CAMPO email =====
    @Schema(
        description = "Correo electrónico del usuario",
        example = "juan.perez@yavirac.edu.ec",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String email;

    // ===== DOCUMENTACIÓN DEL CAMPO password =====
    @Schema(
        description = "Contraseña del usuario",
        example = "123456",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String password;

    // ===== DOCUMENTACIÓN DEL CAMPO confirmPassword =====
    @Schema(
        description = "Confirmación de la contraseña",
        example = "123456",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String confirmPassword;
}