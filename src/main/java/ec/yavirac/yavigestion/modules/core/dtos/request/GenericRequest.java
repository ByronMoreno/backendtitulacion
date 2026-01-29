package ec.yavirac.yavigestion.modules.core.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "Solicitud para las peticiones al sistema")
public class GenericRequest<T> {

    @Schema(
            description = "Usuario que realiza la petición",
            example = "admin"
    )
    private String usrCreacion;

    @Schema(
            description = "Dirección IP desde donde se realiza la solicitud",
            example = "192.168.1.10"
    )
    private String ipCreacion;

    @Schema(
            description = "Método o acción que se desea ejecutar",
            example = "CREATE"
    )
    private String method;

    @Schema(
            description = "Objeto que contiene la información específica de la solicitud",
            example = "{ \"name\": \"Desarrollo de Software\" }"
    )
    private T payload;
}
