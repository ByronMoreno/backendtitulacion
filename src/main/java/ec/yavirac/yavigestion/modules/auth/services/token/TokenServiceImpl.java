package ec.yavirac.yavigestion.modules.auth.services.token;

import ec.yavirac.yavigestion.modules.auth.entities.Token;
import ec.yavirac.yavigestion.modules.auth.entities.User;
import ec.yavirac.yavigestion.modules.auth.repositories.TokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token saveToken(User user, String tokenStr, int expiryMinutes) {
        Token token = new Token();
        token.setUser(user);
        token.setToken(tokenStr);
        token.setExpiryDate(LocalDateTime.now().plusMinutes(expiryMinutes));
        token.setRevoked(false);
        return tokenRepository.save(token);
    }

    @Override
    public List<Token> getValidTokensByUser(User user) {
        return tokenRepository.findAllByUserAndRevokedFalse(user);
    }

    @Override
    public void revokeToken(String tokenStr) {
        tokenRepository.findByToken(tokenStr).ifPresent(token -> {
            token.setRevoked(true);
            tokenRepository.save(token);
        });
    }
}