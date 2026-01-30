package ec.yavirac.yavigestion.modules.administration.services.database.domicilio;

import ec.yavirac.yavigestion.modules.administration.dtos.request.domicilio.CreateDomicilioDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DomicilioResponseDto;
import ec.yavirac.yavigestion.modules.administration.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interfaz para el servicio de base de datos de domicilios.
 */
public interface DomicilioService {
    DomicilioResponseDto save(CreateDomicilioDto dto); // Antes era Domicilio
    Page<DomicilioResponseDto> findAll(Pageable pageable); // Antes era Page<Domicilio>
}