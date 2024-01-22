package api.admin.controllers.issues;

import api.admin.models.entities.Issue;
import api.admin.services.issue.GetActiveIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GetActiveIssuesController {
    private final GetActiveIssueService getActiveIssueService;

    @Autowired
    public GetActiveIssuesController(GetActiveIssueService getActiveIssueService) {
        this.getActiveIssueService = getActiveIssueService;
    }

    @GetMapping(value = "/issues", headers = "Accept=application/json")
    public ResponseEntity<?> getIssuesRoute() {
        try {
            List<Issue> issue = getActiveIssueService.getActiveIssues();
            return new ResponseEntity<>(issue, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al obtener los issue: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
