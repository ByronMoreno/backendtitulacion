package ec.yavirac.yavigestion.modules.administration.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Schema(description = "DTO que representa la información de un Periodo Académico y sus métricas básicas")
public class AcademicPeriodDTO {

    @Schema(description = "Identificador único del periodo académico", example = "1")
    private Long id;

    @Schema(description = "Nombre del periodo (ej. 2025-2025 o Mayo-Octubre)", example = "2025-I")
    private String name;

    @Schema(description = "Breve descripción del ciclo lectivo", example = "Periodo ordinario de clases")
    private String description;

    @Schema(description = "Fecha de inicio de las actividades académicas", example = "2026-05-01")
    private LocalDate startDate;

    @Schema(description = "Fecha de finalización de las actividades académicas", example = "2026-10-31")
    private LocalDate endDate;

    @Schema(description = "Estado administrativo del periodo", allowableValues = {"ACTIVE", "INACTIVE", "CLOSED"})
    private String status;

    @Schema(description = "Cantidad total de carreras asociadas a este periodo", example = "12")
    private Long totalCareers;
}