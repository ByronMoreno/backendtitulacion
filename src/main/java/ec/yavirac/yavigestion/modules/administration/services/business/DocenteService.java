package ec.yavirac.yavigestion.modules.administration.services.business;

import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.CreateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.request.docente.UpdateDocenteDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DocenteDto;
import ec.yavirac.yavigestion.modules.administration.entities.Docente;
import ec.yavirac.yavigestion.modules.administration.repositories.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteDto createDocente(CreateDocenteDto dto) {
        Docente docente = new Docente();
        docente.setNombres(dto.getNombres());
        docente.setApellidos(dto.getApellidos());
        docente.setEmail(dto.getEmail());
        docente.setCarreraId(dto.getCarreraId());

        return mapToDto(docenteRepository.save(docente));
    }

    public List<DocenteDto> getAllDocentes() {
        return docenteRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public DocenteDto getDocenteById(Long id) {
        return mapToDto(findDocente(id));
    }

    public DocenteDto updateDocente(Long id, UpdateDocenteDto dto) {
        Docente docente = findDocente(id);

        docente.setNombres(dto.getNombres());
        docente.setApellidos(dto.getApellidos());
        docente.setEmail(dto.getEmail());
        docente.setCarreraId(dto.getCarreraId());

        return mapToDto(docenteRepository.save(docente));
    }

    public void deleteDocente(Long id) {
        docenteRepository.delete(findDocente(id));
    }

    private Docente findDocente(Long id) {
        return docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
    }

    private DocenteDto mapToDto(Docente docente) {
        return DocenteDto.builder()
                .id(docente.getId())
                .nombres(docente.getNombres())
                .apellidos(docente.getApellidos())
                .email(docente.getEmail())
                .carreraId(docente.getCarreraId())
                .build();
    }
}
