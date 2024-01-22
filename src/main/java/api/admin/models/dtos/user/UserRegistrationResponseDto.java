package api.admin.models.dtos.user;

import lombok.Data;

@Data
public class UserRegistrationResponseDto {
    private String message;
    private UserRegistrationDto user;
}
