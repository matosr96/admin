package api.admin.models.dtos.project;

import lombok.Data;

import java.util.Date;
@Data
public class UpdateProjectDTO {
    private String uuid;
    private String name;
    private String client;
    private String category;
    private Date startDate;
    private Date targetDate;
    private int progress;
    private String[] resources;
    private String description;
    private String lead;
    private String[] members;
}
