package ec.yavirac.yavigestion.modules.administration.services.facades.domicilio;

import ec.yavirac.yavigestion.modules.administration.dtos.request.domicilio.CreateDomicilioDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DomicilioResponseDto;
import ec.yavirac.yavigestion.modules.administration.services.database.domicilio.DomicilioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class DomicilioFacadeImpl implements DomicilioFacade {

    // Cambiamos el Repository por el Service
    private final DomicilioService domicilioService;

    @Override
    public DomicilioResponseDto guardar(CreateDomicilioDto dto) {
        System.out.println(">>> PASANDO POR EL FACADE: Orquestando hacia el Service...");
        // El Facade le pasa el DTO al Service
        return domicilioService.save(dto);
    }

    @Override
    public Page<DomicilioResponseDto> listar(Pageable pageable) { // Debe coincidir EXACTAMENTE
        System.out.println(">>> PASANDO POR EL FACADE: Solicitando lista paginada...");
        return domicilioService.findAll(pageable);
    }
}