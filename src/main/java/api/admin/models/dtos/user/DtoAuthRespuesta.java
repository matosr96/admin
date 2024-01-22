package api.admin.models.dtos.user;

import api.admin.models.entities.User;
import lombok.Data;

@Data
public class DtoAuthRespuesta {
    private String accessToken;
    private String tokenType = "Bearer ";
    private User user;

    public DtoAuthRespuesta(String accessToken, User user) {
        this.accessToken = accessToken;
        this.user = user;
    }
}
