package api.admin.models.dtos.user;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String name;
    private String email;
    private String password;
    private String role;
    private String photo;
}
