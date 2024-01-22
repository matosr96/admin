package api.admin.models.entities;

import api.admin.models.commons.Base;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "issues")
@Data
public class Issue extends Base {
    private String user;
    private String type;
    private Integer code;
    private String summary;
    private String description;
    private String priority;
    private List<String> assignees;
    private String reporter;
    private Integer estimate;
    private String project;
    private Integer listPosition;
    private String statusIssue;
    private Integer progress;
    private List<String> attachments;
    private List<CommentIssue> comments;
    private List<Subtask> subtasks;
    private List<Label> labels;
    private String dueDate;
}
