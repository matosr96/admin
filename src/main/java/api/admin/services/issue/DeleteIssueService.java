package api.admin.services.issue;

import api.admin.models.entities.Issue;
import api.admin.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeleteIssueService {
    private final IssueRepository issueRepository;

    @Autowired
    public DeleteIssueService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    public boolean deleteIssue(String uuid){
        try {
            List<Issue> isssues = issueRepository.findAll();
            Issue issueFound = null;
            for (Issue issue : isssues) {
                if (issue.getUuid().equals(uuid)) {
                    issueFound = issue;
                    break;
                }
            }
            if (issueFound != null) {
                issueRepository.delete(issueFound);
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
