package ec.yavirac.yavigestion.modules.auth.services.token;

import ec.yavirac.yavigestion.modules.auth.entities.Token;
import ec.yavirac.yavigestion.modules.auth.entities.User;
import java.util.List;

public interface TokenService {

    Token saveToken(User user, String token, int expiryMinutes);

    List<Token> getValidTokensByUser(User user);

    void revokeToken(String token);
}
