package api.admin.services.auth;

import api.admin.configuration.jwt.JwtGenerator;
import api.admin.controllers.auth.SignInController;
import api.admin.models.dtos.user.UserRegistrationDto;
import api.admin.models.dtos.user.UserSignInDto;
import api.admin.models.dtos.user.UserSignInResponseDto;
import api.admin.models.entities.User;
import api.admin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SignInService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtGenerator jwtGenerator;

    private static final Logger LOGGER = Logger.getLogger(SignInController.class.getName());

    @Autowired
    public SignInService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    public UserSignInResponseDto signIn(UserSignInDto signInDto) {
        try {
            String email = signInDto.getEmail();
            String password = signInDto.getPassword();
            List<User> usersArray = userRepository.findAll();
            User userToSignIn = null;

            for (User user : usersArray) {
                if (user.getEmail().equals(email)) {
                    userToSignIn = user;
                    break;
                }
            }

            if (userToSignIn != null) {
                if (passwordEncoder.matches(password, userToSignIn.getPassword())) {
                    String token = jwtGenerator.generateToken(userToSignIn.getEmail());
                    UserSignInResponseDto responseDto = new UserSignInResponseDto();
                    responseDto.setToken(token);
                    responseDto.setUser(userToSignIn);
                    return responseDto;
                } else {
                    throw new IllegalArgumentException("Contraseña incorrecta");
                }
            } else {
                throw new IllegalArgumentException("Email no encontrado");
            }

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.severe("Error al procesar el inicio de sesión: " + e);
            throw new RuntimeException("Error interno al procesar el inicio de sesión");
        }
    }
}