package ec.yavirac.yavigestion.modules.auth.repositories;

import ec.yavirac.yavigestion.modules.auth.entities.Token;
import ec.yavirac.yavigestion.modules.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);

    List<Token> findAllByUserAndRevokedFalse(User user);
}