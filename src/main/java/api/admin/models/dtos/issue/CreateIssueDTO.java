package api.admin.models.dtos.issue;

import api.admin.models.entities.CommentIssue;
import api.admin.models.entities.Label;
import api.admin.models.entities.Subtask;
import lombok.Data;

import java.util.List;
@Data
public class CreateIssueDTO {
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
