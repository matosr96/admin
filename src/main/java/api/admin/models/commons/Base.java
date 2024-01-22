package api.admin.models.commons;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Base {
    @Id
    private String id;
    private String uuid;
    private String status;
}
