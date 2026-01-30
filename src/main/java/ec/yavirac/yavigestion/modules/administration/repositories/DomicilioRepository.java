package ec.yavirac.yavigestion.modules.administration.repositories;

import ec.yavirac.yavigestion.modules.administration.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}