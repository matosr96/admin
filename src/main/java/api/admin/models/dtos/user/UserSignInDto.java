package api.admin.models.dtos.user;

import lombok.Data;

@Data
public class UserSignInDto {
    private String email;
    private String password;
}
