package ec.yavirac.yavigestion.modules.core.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "Respuesta para retornar información al cliente")
public class GenericResponse<T> {

    @Schema(
            description = "Mensaje descriptivo del resultado de la operación",
            example = "Operación realizada correctamente"
    )
    private String message;

    @Schema(
            description = "Código de estado HTTP de la respuesta",
            example = "200"
    )
    private int status;

    @Schema(
            description = "Objeto que contiene la información retornada por el servicio",
            example = "{ \"id\": 1, \"name\": \"Desarrollo de Sotware\" }"
    )
    private T data;
}
