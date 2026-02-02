package ec.yavirac.yavigestion.modules.administration.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DocenteDto {
    private Long id;
    private String nombres;
    private String apellidos;
    private String email;
    private Long carreraId;
}
