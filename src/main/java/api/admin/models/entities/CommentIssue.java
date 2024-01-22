package api.admin.models.entities;

import lombok.Data;

@Data
public class CommentIssue {
    private String uuid;
    private String text;
    private String author;
}
