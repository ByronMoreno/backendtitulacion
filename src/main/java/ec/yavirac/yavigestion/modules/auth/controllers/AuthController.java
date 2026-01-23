package ec.yavirac.yavigestion.modules.auth.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.yavirac.yavigestion.modules.auth.dtos.request.AuthRequest;      // Describe cada endpoint
import ec.yavirac.yavigestion.modules.auth.dtos.request.RegisterRequest;   // Define una respuesta HTTP
import ec.yavirac.yavigestion.modules.auth.dtos.response.AuthResponse;  // Agrupa varias respuestas
import ec.yavirac.yavigestion.modules.auth.services.authentication.AuthenticationService;       // Agrupa endpoints en Swagger
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/auth")
@Log4j2

// ===== ANOTACIÓN AGREGADA A NIVEL DE CLASE =====
// Agrupa todos los endpoints de autenticación bajo "Auth" en Swagger UI
@Tag(
    name = "Auth",
    description = "Endpoints para autenticación y registro de usuarios"
)
public class AuthController {

    @Qualifier("authenticationServiceImpl")
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // ===== DOCUMENTACIÓN DEL ENDPOINT REGISTER =====
    @Operation(
        summary = "Registrar usuario",           // Qué hace el endpoint
        description = "Permite registrar un nuevo usuario en el sistema"
    )
    @ApiResponses({                             // Posibles respuestas HTTP
        @ApiResponse(responseCode = "201", description = "Usuario registrado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "409", description = "El usuario ya existe")
    })
    @PostMapping("/register")
    public ResponseEntity<GenericOnlyTextResponse> register(
            @RequestBody RegisterRequest req   // Datos enviados en JSON
    ) {
        log.info("Registrando usuario: {}", req.getEmail());

        GenericOnlyTextResponse response = authenticationService.register(req);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    // ===== DOCUMENTACIÓN DEL ENDPOINT LOGIN =====
    @Operation(
        summary = "Iniciar sesión",            // Qué hace el login
        description = "Autentica al usuario y devuelve un token JWT"
    )
    @ApiResponses({                             // Posibles respuestas HTTP
        @ApiResponse(responseCode = "200", description = "Login exitoso"),
        @ApiResponse(responseCode = "401", description = "Credenciales incorrectas"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PostMapping("/login")
    public ResponseEntity<GenericResponse<AuthResponse>> login(
            @RequestBody AuthRequest req      // Datos de autenticación en JSON
    ) {
        log.info("El usuario {} esta intentando entrar al sistema", req.getEmail());

        GenericResponse<AuthResponse> response = authenticationService.login(req);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }
}