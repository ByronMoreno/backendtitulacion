package ec.yavirac.yavigestion.modules.auth.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.yavirac.yavigestion.modules.auth.dtos.request.AuthRequest;
import ec.yavirac.yavigestion.modules.auth.dtos.request.RegisterRequest;
import ec.yavirac.yavigestion.modules.auth.dtos.response.AuthResponse;
import ec.yavirac.yavigestion.modules.auth.services.authentication.AuthenticationService;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericOnlyTextResponse;
import ec.yavirac.yavigestion.modules.core.dtos.response.GenericResponse;
import lombok.extern.log4j.Log4j2;

/**
 * Controlador encargado de la autenticación de usuarios.
 *
 * <p>Este controlador expone los endpoints necesarios para:
 * <ul>
 *   <li>Registro de nuevos usuarios</li>
 *   <li>Inicio de sesión (login)</li>
 * </ul>
 *
 * Todos los endpoints están disponibles bajo la ruta base <b>/auth</b>.
 */
@RestController
@RequestMapping("/auth")
@Log4j2
public class AuthController {

    /**
     * Servicio de autenticación encargado de la lógica de negocio
     * relacionada con el registro y login de usuarios.
     */
    @Qualifier("authenticationServiceImpl")
    private final AuthenticationService authenticationService;

    /**
     * Constructor del controlador de autenticación.
     *
     * @param authenticationService implementación del servicio de autenticación
     */
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Endpoint para registrar un nuevo usuario en el sistema.
     *
     * @param req objeto {@link RegisterRequest} que contiene los datos
     *            necesarios para el registro del usuario
     * @return {@link ResponseEntity} con un mensaje de texto y el estado
     *         correspondiente de la operación
     */
    @PostMapping("/register")
    public ResponseEntity<GenericOnlyTextResponse> register(@RequestBody RegisterRequest req) {
        log.info("Registrando usuario: {}", req.getEmail());

        GenericOnlyTextResponse response = authenticationService.register(req);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    /**
     * Endpoint para autenticar a un usuario en el sistema.
     *
     * @param req objeto {@link AuthRequest} que contiene las credenciales
     *            del usuario (correo y contraseña)
     * @return {@link ResponseEntity} con la información de autenticación
     *         y el estado correspondiente de la operación
     */
    @PostMapping("/login")
    public ResponseEntity<GenericResponse<AuthResponse>> login(@RequestBody AuthRequest req) {
        log.info("El usuario {} esta intentando entrar al sistema", req.getEmail());

        GenericResponse<AuthResponse> response = authenticationService.login(req);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }
}
