package ec.yavirac.yavigestion.modules.administration.dtos.response;

import ec.yavirac.yavigestion.modules.administration.enums.CareerType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "DTO que representa la información detallada de una Carrera")
public class CareerDTO {

    @Schema(description = "Identificador único de la carrera", example = "10")
    private Long id;

    @Schema(description = "Nombre oficial de la carrera", example = "Desarrollo de Software")
    private String name;

    @Schema(description = "Descripción del perfil profesional o malla curricular", example = "Carrera enfocada en la creación de soluciones tecnológicas")
    private String description;

    @Schema(description = "Define si la modalidad de la carrera es DUAL o TRADICIONAL")
    private CareerType isDual;

    @Schema(description = "Estado operativo de la carrera", allowableValues = {"ACTIVE", "INACTIVE"})
    private String status;
}