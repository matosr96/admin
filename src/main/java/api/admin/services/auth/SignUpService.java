package api.admin.services.auth;

import api.admin.models.dtos.user.UserRegistrationDto;
import api.admin.models.entities.User;
import api.admin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignUpService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(UserRegistrationDto userDto) {
        User user = new User();
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhoto(userDto.getPhoto());
        user.setRol(userDto.getRole());
        user.setStatus("active");
        userRepository.save(user);
        return userRepository.save(user);
    }
}
