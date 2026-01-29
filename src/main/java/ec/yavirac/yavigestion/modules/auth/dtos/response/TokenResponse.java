package ec.yavirac.yavigestion.modules.auth.dtos.response;

import java.time.LocalDateTime;

public class TokenResponse {
    private String token;
    private LocalDateTime expiryDate;

    public TokenResponse(String token, LocalDateTime expiryDate) {
        this.token = token;
        this.expiryDate = expiryDate;
    }

    public String getToken() { return token; }
    public LocalDateTime getExpiryDate() { return expiryDate; }
}
