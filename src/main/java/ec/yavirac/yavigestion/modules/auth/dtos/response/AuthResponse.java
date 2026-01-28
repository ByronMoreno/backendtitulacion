package ec.yavirac.yavigestion.modules.auth.dtos.response;

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
        name = "AuthResponse",
        description = "Respuesta generada cuando el usuario se autentica correctamente"
)
public class AuthResponse {

    @Schema(
            description = "Token JWT generado por el sistema para autenticación",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyQHlhdmlyYWMuZWR1LmVjIiwiZXhwIjoxNzAwMDAwMDAwfQ.firmaJWT",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String token;
}