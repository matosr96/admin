package api.admin.services.issue;

import api.admin.models.entities.Issue;
import api.admin.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeleteIssueStatusService {
    private final IssueRepository issueRepository;

    @Autowired
    public DeleteIssueStatusService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    public Issue updateStatusToDelete(String uuid) {
        try {
            List<Issue> issueList = issueRepository.findAll();
            Issue issueFound = null;
            for (Issue issue : issueList) {
                if (issue.getUuid().equals(uuid)) {
                    issueFound = issue;
                    break;
                }
            }
            if (issueFound != null) {
                issueFound.setStatus("deleted");
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
