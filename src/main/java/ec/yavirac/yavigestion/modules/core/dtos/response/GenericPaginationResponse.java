package ec.yavirac.yavigestion.modules.core.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(description = "Respuesta para retornar listas de información")
public class GenericPaginationResponse<T> {

    @Schema(
            description = "Mensaje descriptivo del resultado de la operación",
            example = "Consulta realizada correctamente"
    )
    private String message;

    @Schema(
            description = "Código de estado HTTP de la respuesta",
            example = "200"
    )
    private int status;

    @Schema(
            description = "Lista de elementos correspondientes a la página solicitada",
            example = "[{ \"id\": 1, \"name\": \"Desarrollo de Software\" }]"
    )
    private List<T> data;

    @Schema(
            description = "Número total de páginas disponibles",
            example = "5"
    )
    private int totalPages;

    @Schema(
            description = "Número de la página actual (iniciando desde 0)",
            example = "0"
    )
    private int currentPage;

    @Schema(
            description = "Número total de elementos disponibles",
            example = "42"
    )
    private long totalElements;

    @Schema(
            description = "Cantidad de elementos por página",
            example = "10"
    )
    private int pageSize;
}
