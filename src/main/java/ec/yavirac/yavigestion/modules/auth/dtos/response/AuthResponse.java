package ec.yavirac.yavigestion.modules.auth.dtos.response;

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
// @Schema define el DTO en Swagger con nombre y descripción
@Schema(
    name = "AuthResponse",                                      // Nombre que aparecerá en Swagger
    description = "Respuesta generada cuando el usuario se autentica correctamente" // Qué representa
)
public class AuthResponse {

    // ===== DOCUMENTACIÓN DEL CAMPO token =====
    @Schema(
        description = "Token JWT generado por el sistema",      // Qué representa
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyQHlhdmlyYWMuZWR1LmVjIiwiZXhwIjoxNzAwMDAwMDAwfQ.firmaJWT"  // Ejemplo de JWT
    )
    private String token;
}