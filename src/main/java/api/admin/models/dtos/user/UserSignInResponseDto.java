package api.admin.models.dtos.user;

import api.admin.models.entities.User;
import lombok.Data;

@Data
public class UserSignInResponseDto {
    private String token;
    private User user;
}
