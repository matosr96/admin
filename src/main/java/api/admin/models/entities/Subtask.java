package api.admin.models.entities;

import lombok.Data;

@Data
public class Subtask {
    private String uuid;
    private Integer code;
    private String description;
    private boolean status;
}
