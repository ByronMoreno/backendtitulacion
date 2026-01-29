package ec.yavirac.yavigestion.modules.administration.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "DTO consolidado para las estadísticas globales del panel de control (Dashboard)")
public class DashboardStatsDTO {

    @Schema(description = "Cantidad total de usuarios registrados en el sistema", example = "150")
    private Long totalUsers;

    @Schema(description = "Cantidad total de carreras técnicas y tecnológicas creadas", example = "12")
    private Long totalCareers;

    @Schema(description = "Histórico total de periodos académicos registrados", example = "5")
    private Long totalAcademicPeriods;

    @Schema(description = "Cantidad de periodos académicos que se encuentran vigentes (Estado ACTIVE)", example = "1")
    private Long totalActivePeriods;
}