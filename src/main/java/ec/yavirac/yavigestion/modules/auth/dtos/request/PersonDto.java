package ec.yavirac.yavigestion.modules.auth.dtos.request;

import java.time.LocalDate;

import ec.yavirac.yavigestion.modules.administration.enums.BloodType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

// ===== DOCUMENTACIÓN DEL DTO =====
@Schema(description = "Información personal asociada al usuario")
public class PersonDto {

    @Schema(
            description = "Identificador único de la persona",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Nombres de la persona",
            example = "Juan"
    )
    private String name;

    @Schema(
            description = "Apellidos de la persona",
            example = "Pérez"
    )
    private String lastname;

    @Schema(
            description = "Número de identificación (cédula)",
            example = "0102030405"
    )
    private String dni;

    @Schema(
            description = "Número de teléfono de contacto",
            example = "0999999999"
    )
    private String phonenumber;

    @Schema(
            description = "Dirección domiciliaria",
            example = "Quito"
    )
    private String address;

    @Schema(
            description = "Tipo de sangre",
            example = "O_POSITIVE",
            allowableValues = {
                    "O_POSITIVE", "O_NEGATIVE",
                    "A_POSITIVE", "A_NEGATIVE",
                    "B_POSITIVE", "B_NEGATIVE",
                    "AB_POSITIVE", "AB_NEGATIVE"
            }
    )
    private BloodType bloodtype;

    @Schema(
            description = "Género de la persona",
            example = "M"
    )
    private String gender;

    @Schema(
            description = "Fecha de nacimiento (YYYY-MM-DD)",
            example = "1995-08-20"
    )
    private LocalDate birthdate;

    @Schema(
            description = "Correo electrónico personal",
            example = "juan@test.com"
    )
    private String email;

    @Schema(
            description = "Estado del registro",
            example = "ACTIVE",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String status;
}