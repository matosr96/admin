package api.admin.services.issue;

import api.admin.models.dtos.issue.CreateIssueDTO;
import api.admin.models.entities.Issue;
import api.admin.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateIssueService {
    private final IssueRepository issueRepository;

    @Autowired
    public CreateIssueService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    public Issue createIssue(CreateIssueDTO createIssueDTO) {
        Issue issue = new Issue();
        String uuid = UUID.randomUUID().toString();
        issue.setUuid(uuid);
        issue.setStatus("active");
        issue.setType(createIssueDTO.getType());
        issue.setUser(createIssueDTO.getUser());
        issue.setCode(createIssueDTO.getCode());
        issue.setSummary(createIssueDTO.getSummary());
        issue.setDescription(createIssueDTO.getDescription());
        issue.setPriority(createIssueDTO.getPriority());
        issue.setAssignees(createIssueDTO.getAssignees());
        issue.setReporter(createIssueDTO.getReporter());
        issue.setEstimate(createIssueDTO.getEstimate());
        issue.setProject(createIssueDTO.getProject());
        issue.setListPosition(createIssueDTO.getListPosition());
        issue.setStatusIssue(createIssueDTO.getStatusIssue());
        issue.setProgress(createIssueDTO.getProgress());
        issue.setAttachments(createIssueDTO.getAttachments());
        issue.setComments(createIssueDTO.getComments());
        issue.setSubtasks(createIssueDTO.getSubtasks());
        issue.setLabels(createIssueDTO.getLabels());
        issue.setDueDate(createIssueDTO.getDueDate());

        return issueRepository.save(issue);
    }
}
