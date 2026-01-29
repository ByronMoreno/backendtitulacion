package ec.yavirac.yavigestion.modules.auth.controllers;

import ec.yavirac.yavigestion.modules.auth.dtos.response.TokenResponse;
import ec.yavirac.yavigestion.modules.auth.entities.User;
import ec.yavirac.yavigestion.modules.auth.services.token.TokenService;
import ec.yavirac.yavigestion.modules.auth.services.authentication.AuthenticationService; // para obtener User
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth/token")
public class TokenController {

    private final TokenService tokenService;
    private final AuthenticationService authenticationService; // Para obtener el User

    public TokenController(TokenService tokenService, AuthenticationService authenticationService) {
        this.tokenService = tokenService;
        this.authenticationService = authenticationService;
    }

    // 1️⃣ Crear un token nuevo para un usuario
    @PostMapping("/create")
    public ResponseEntity<TokenResponse> createToken(
            @RequestParam String username,
            @RequestParam int expiryMinutes
    ) {
        User user = authenticationService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        // Generar token aleatorio simple (UUID)
        String tokenStr = java.util.UUID.randomUUID().toString();

        var token = tokenService.saveToken(user, tokenStr, expiryMinutes);

        return ResponseEntity.ok(new TokenResponse(token.getToken(), token.getExpiryDate()));
    }

    // 2️⃣ Listar tokens válidos de un usuario
    @GetMapping("/user/{username}")
    public ResponseEntity<List<TokenResponse>> getValidTokens(@PathVariable String username) {
        User user = authenticationService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<TokenResponse> tokens = tokenService.getValidTokensByUser(user)
                .stream()
                .map(t -> new TokenResponse(t.getToken(), t.getExpiryDate()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(tokens);
    }

    // 3️⃣ Revocar un token específico
    @PostMapping("/revoke")
    public ResponseEntity<String> revokeToken(@RequestParam String token) {
        tokenService.revokeToken(token);
        return ResponseEntity.ok("Token revocado correctamente");
    }
}