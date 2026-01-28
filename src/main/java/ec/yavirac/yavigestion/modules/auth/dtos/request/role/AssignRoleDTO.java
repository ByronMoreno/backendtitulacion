package ec.yavirac.yavigestion.modules.auth.dtos.request.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(description = "DTO utilizado para asignar uno o varios roles a un usuario")
public class AssignRoleDTO {

    @Schema(
            description = "Lista de identificadores de roles a asignar al usuario",
            example = "[1, 2, 3]",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private List<Long> roleIds;
}
