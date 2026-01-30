package ec.yavirac.yavigestion.modules.administration.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Respuesta detallada con los datos del domicilio procesado")
public class DomicilioResponseDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Av. Amazonas")
    private String callePrincipal;

    @Schema(example = "Corea")
    private String calleSecundaria;

    @Schema(example = "Frente al CCI")
    private String referencia;

    @Schema(example = "ACTIVO")
    private String estado;
}