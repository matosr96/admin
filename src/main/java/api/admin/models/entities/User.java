package api.admin.models.entities;

import api.admin.models.commons.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User extends Base {
    private String name;
    private String email;
    private String password;
    private String rol;
    private String photo;
}
