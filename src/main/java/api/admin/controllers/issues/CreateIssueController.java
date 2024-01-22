package api.admin.controllers.issues;

import api.admin.models.dtos.issue.CreateIssueDTO;
import api.admin.models.dtos.project.CreateProjectDTO;
import api.admin.models.entities.Issue;
import api.admin.models.entities.Project;
import api.admin.services.issue.CreateIssueService;
import api.admin.services.projects.CreateProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreateIssueController {
    private final CreateIssueService createIssueService;

    @Autowired
    public CreateIssueController(CreateIssueService createIssueService) {
        this.createIssueService = createIssueService;
    }

    @PostMapping(value = "/issues", headers = "Accept=application/json")
    public ResponseEntity<?> createIssueRoute(@RequestBody CreateIssueDTO createIssueDTO) {
        try {
            Issue project = createIssueService.createIssue(createIssueDTO);
            return new ResponseEntity<>(project, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al crear la issue: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
