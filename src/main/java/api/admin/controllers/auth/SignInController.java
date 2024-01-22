package api.admin.controllers.auth;

import api.admin.models.dtos.user.UserSignInDto;
import api.admin.models.dtos.user.UserSignInResponseDto;
import api.admin.services.auth.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class SignInController {
    private final SignInService signInService;

    private static final Logger LOGGER = Logger.getLogger(SignInController.class.getName());

    @Autowired
    public SignInController(SignInService signInService) {
        this.signInService = signInService;
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserSignInDto signInDto) {
        try {
            UserSignInResponseDto response = signInService.signIn(signInDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno al iniciar sesión", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
