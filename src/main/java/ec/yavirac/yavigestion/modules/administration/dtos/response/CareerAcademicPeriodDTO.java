package ec.yavirac.yavigestion.modules.administration.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Schema(description = "DTO detallado que vincula un Periodo Académico con sus métricas de carreras y modalidades")
public class CareerAcademicPeriodDTO {

    @Schema(description = "ID del periodo académico", example = "1")
    private Long id;

    @Schema(description = "Nombre del periodo", example = "2025-II")
    private String name;

    @Schema(description = "Descripción del ciclo", example = "Periodo académico ordinario")
    private String description;

    @Schema(description = "Fecha de inicio del periodo", example = "2025-11-01")
    private LocalDate startDate;

    @Schema(description = "Fecha de fin del periodo", example = "2026-03-31")
    private LocalDate endDate;

    @Schema(description = "Estado del periodo", allowableValues = {"ACTIVE", "INACTIVE"})
    private String status;

    @Schema(description = "Total global de carreras vinculadas", example = "10")
    private Long totalCareers;

    @Schema(description = "Total de carreras con estado activo", example = "8")
    private Long totalActiveCareers;

    @Schema(description = "Listado detallado de las carreras asociadas")
    private List<CareerDTO> careers;

    @Schema(description = "Contador de carreras en modalidad Tradicional", example = "6")
    private Long totalTraditional;

    @Schema(description = "Contador de carreras en modalidad Dual", example = "4")
    private Long totalDual;
}