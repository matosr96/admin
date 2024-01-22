package api.admin.services.issue;

import api.admin.models.entities.Issue;
import api.admin.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetActiveIssueService {
    private final IssueRepository issueRepository;

    @Autowired
    public GetActiveIssueService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    public List<Issue> getActiveIssues(){
        List<Issue> issuetList = issueRepository.findAll();
        List<Issue> activeIssues = new ArrayList<>();
        for (Issue issue : issuetList) {
            if (issue.getStatus().equals("active")) {
                activeIssues.add(issue);
            }
        }
        return activeIssues;
    }
}
