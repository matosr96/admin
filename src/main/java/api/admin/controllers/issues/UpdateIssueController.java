package api.admin.controllers.issues;

import api.admin.models.dtos.issue.UpdateIssueDTO;
import api.admin.models.entities.Issue;
import api.admin.services.issue.UpdateIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UpdateIssueController {
    private final UpdateIssueService updateIssueService;

    @Autowired
    public UpdateIssueController(UpdateIssueService updateIssueService){
        this.updateIssueService = updateIssueService;
    }

    @PutMapping(value = "/issues", headers = "Accept=application/json")
    public ResponseEntity<?> updateProjectRoute(@RequestBody UpdateIssueDTO updateIssueDTO) {
        try {
            Issue issue = updateIssueService.updateIssue(updateIssueDTO);
            return new ResponseEntity<>(issue, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al obtener los issues: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
