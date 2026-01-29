package ec.yavirac.yavigestion.modules.core.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Estructura utilizada para retornar información detallada de errores del sistema")
public class ErrorResponse {

    @Schema(
            description = "Título corto que identifica el tipo de error",
            example = "Error de validación"
    )
    private String title;

    @Schema(
            description = "Mensaje descriptivo del error ocurrido",
            example = "El campo nombre es obligatorio"
    )
    private String message;

    @Schema(
            description = "Información adicional o detalles técnicos del error",
            example = "{ \"field\": \"name\", \"error\": \"must not be null\" }"
    )
    private Object details;

    @Schema(
            description = "Fecha y hora en que ocurrió el error",
            example = "2024-01-15T10:30:00"
    )
    private LocalDateTime timestamp;

    public ErrorResponse(String title, String message, Object details) {
        this.title = title;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String title, String message) {
        this.title = title;
        this.message = message;
        this.details = null;
        this.timestamp = LocalDateTime.now();
    }
}
