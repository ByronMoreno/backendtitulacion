package ec.yavirac.yavigestion.modules.administration.dtos.request.domicilio;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Datos necesarios para registrar un nuevo domicilio")
public class CreateDomicilioDto {

    @Schema(example = "Av. Amazonas", description = "Calle principal del domicilio", required = true)
    private String callePrincipal;

    @Schema(example = "Corea", description = "Calle secundaria o intersección")
    private String calleSecundaria;

    @Schema(example = "Frente al CCI", description = "Referencia física para ubicación")
    private String referencia;

    @Schema(example = "Iñaquito", description = "Nombre del barrio o sector")
    private String barrio;
}