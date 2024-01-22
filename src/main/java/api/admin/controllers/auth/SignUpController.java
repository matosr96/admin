package api.admin.controllers.auth;

import api.admin.models.dtos.user.UserRegistrationDto;
import api.admin.models.entities.User;
import api.admin.services.auth.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SignUpController {
    private  final SignUpService signUpService;
    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserRegistrationDto registrationDto) {
        try {
            User response = signUpService.signUp(registrationDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }  catch (Exception e) {
            return new ResponseEntity<>("Error interno al registrar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
