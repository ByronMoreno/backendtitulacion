package ec.yavirac.yavigestion.modules.administration.services.database.domicilio;

import ec.yavirac.yavigestion.modules.administration.dtos.request.domicilio.CreateDomicilioDto;
import ec.yavirac.yavigestion.modules.administration.dtos.response.DomicilioResponseDto;
import ec.yavirac.yavigestion.modules.administration.entities.Domicilio;
import ec.yavirac.yavigestion.modules.administration.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    @Transactional
    public DomicilioResponseDto save(CreateDomicilioDto dto) {
        // 1. Convertir DTO a Entidad (Mapeo de entrada)
        Domicilio entidad = new Domicilio();
        entidad.setCallePrincipal(dto.getCallePrincipal());
        entidad.setCalleSecundaria(dto.getCalleSecundaria());
        entidad.setReferencia(dto.getReferencia());
        // entidad.setBarrio(dto.getBarrio()); // Descomenta si agregaste barrio al DTO

        // 2. Guardar en la base de datos
        Domicilio guardado = domicilioRepository.save(entidad);

        // 3. Convertir Entidad a Response DTO (Mapeo de salida)
        return DomicilioResponseDto.builder()
                .id(guardado.getId().longValue())
                .callePrincipal(guardado.getCallePrincipal())
                .calleSecundaria(guardado.getCalleSecundaria())
                .referencia(guardado.getReferencia())
                .estado("ACTIVO") // O el campo que manejes para el estado
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DomicilioResponseDto> findAll(Pageable pageable) {
        // Obtenemos la página de entidades y usamos .map() para convertir cada una a DTO
        return domicilioRepository.findAll(pageable).map(this::mapToResponseDto);
    }

    /**
     * Método auxiliar para convertir una Entidad Domicilio a DomicilioResponseDto
     */
    private DomicilioResponseDto mapToResponseDto(Domicilio entidad) {
        return DomicilioResponseDto.builder()
                .id(entidad.getId().longValue())
                .callePrincipal(entidad.getCallePrincipal())
                .calleSecundaria(entidad.getCalleSecundaria())
                .referencia(entidad.getReferencia())
                .estado("ACTIVO")
                .build();
    }
}