package ec.yavirac.yavigestion.modules.auth.dtos.request.role;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "DTO para la asignación de uno o varios roles a un usuario")
public class AssignRoleDTO {

    @Schema(
            description = "Lista de identificadores de roles que serán asignados al usuario",
            example = "[1, 2, 3]"
    )
    private List<Long> roleIds;
}
