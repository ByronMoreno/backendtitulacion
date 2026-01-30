package ec.yavirac.yavigestion.modules.administration.services.facades.domicilio;

import ec.yavirac.yavigestion.modules.administration.dtos.request.domicilio.CreateDomicilioDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DomicilioResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DomicilioFacade {
    DomicilioResponseDto guardar(CreateDomicilioDto dto);

    // ASEGÚRATE DE QUE ESTE NOMBRE SEA "listar" Y RECIBA EL Pageable
    Page<DomicilioResponseDto> listar(Pageable pageable);
}