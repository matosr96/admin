package api.admin.models.entities;

import api.admin.models.commons.Base;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Document(collection = "projects")
public class Project extends Base {
    private String user;
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
