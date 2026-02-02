package ec.yavirac.yavigestion.modules.administration.dtos.request.docente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateDocenteDto {
    private String nombres;
    private String apellidos;
    private String email;
    private Long carreraId;
}
