package ec.yavirac.yavigestion.modules.administration.services.facades.docente;

import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.CreateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.UpdateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DocenteDto;
import ec.yavirac.yavigestion.modules.administration.services.business.DocenteService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteFacadeImpl implements DocenteFacade {

    private final DocenteService docenteService;

    @Override
    public DocenteDto create(CreateDocenteDto dto) {
        return docenteService.createDocente(dto);
    }

    @Override
    public List<DocenteDto> findAll() {
        return docenteService.getAllDocentes();
    }

    @Override
    public DocenteDto findById(Long id) {
        return docenteService.getDocenteById(id);
    }

    @Override
    public DocenteDto update(Long id, UpdateDocenteDto dto) {
        return docenteService.updateDocente(id, dto);
    }

    @Override
    public void delete(Long id) {
        docenteService.deleteDocente(id);
    }
}
