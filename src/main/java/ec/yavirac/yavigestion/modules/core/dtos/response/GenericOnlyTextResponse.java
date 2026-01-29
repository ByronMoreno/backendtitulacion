package ec.yavirac.yavigestion.modules.core.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "Respuesta  para retornar únicamente un mensaje de texto")
public class GenericOnlyTextResponse {

    @Schema(
            description = "Mensaje descriptivo del resultado de la operación",
            example = "Registro eliminado correctamente"
    )
    private String message;

    @Schema(
            description = "Código de estado HTTP de la respuesta",
            example = "200"
    )
    private int status;
}
