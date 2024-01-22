package api.admin.services.issue;

import api.admin.models.dtos.issue.UpdateIssueDTO;
import api.admin.models.entities.Issue;
import api.admin.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UpdateIssueService {
    private final IssueRepository issueRepository;

    @Autowired
    public UpdateIssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public Issue updateIssue(UpdateIssueDTO updateIssueDTO) {
        try {
            List<Issue> issueList = issueRepository.findAll();
            Issue issueFound = null;
            for (Issue issue : issueList) {
                if (issue.getUuid().equals(updateIssueDTO.getUuid())) {
                    issueFound = issue;
                    break;
                }
            }
            if (issueFound != null) {
                issueFound.setType(updateIssueDTO.getType());
                issueFound.setCode(updateIssueDTO.getCode());
                issueFound.setSummary(updateIssueDTO.getSummary());
                issueFound.setDescription(updateIssueDTO.getDescription());
                issueFound.setPriority(updateIssueDTO.getPriority());
                issueFound.setAssignees(updateIssueDTO.getAssignees());
                issueFound.setReporter(updateIssueDTO.getReporter());
                issueFound.setEstimate(updateIssueDTO.getEstimate());
                issueFound.setProject(updateIssueDTO.getProject());
                issueFound.setListPosition(updateIssueDTO.getListPosition());
                issueFound.setStatusIssue(updateIssueDTO.getStatusIssue());
                issueFound.setProgress(updateIssueDTO.getProgress());
                issueFound.setAttachments(updateIssueDTO.getAttachments());
                issueFound.setComments(updateIssueDTO.getComments());
                issueFound.setSubtasks(updateIssueDTO.getSubtasks());
                issueFound.setLabels(updateIssueDTO.getLabels());
                issueFound.setDueDate(updateIssueDTO.getDueDate());

                return issueRepository.save(issueFound);
            } else {
                return null;
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
