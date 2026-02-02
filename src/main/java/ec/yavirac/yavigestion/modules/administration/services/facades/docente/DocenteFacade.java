package ec.yavirac.yavigestion.modules.administration.services.facades.docente;

import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.CreateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.UpdateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DocenteDto;

import java.util.List;

public interface DocenteFacade {

    DocenteDto create(CreateDocenteDto dto);

    List<DocenteDto> findAll();

    DocenteDto findById(Long id);

    DocenteDto update(Long id, UpdateDocenteDto dto);

    void delete(Long id);
}
