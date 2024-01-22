package api.admin.controllers.issues;

import api.admin.models.entities.Issue;
import api.admin.services.issue.DeleteIssueStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DeleteIssueStatusController {
    private final DeleteIssueStatusService deleteIssueStatusService;

    public DeleteIssueStatusController(DeleteIssueStatusService deleteIssueStatusService){
        this.deleteIssueStatusService = deleteIssueStatusService;
    }

    @PutMapping(value = "/issues/{uuid}", headers = "Accept=application/json")
    public ResponseEntity<?> DeleteIssueStatusRoute(@PathVariable("uuid") String uuid) {
        try {
            Issue issue = deleteIssueStatusService.updateStatusToDelete(uuid);
            return new ResponseEntity<>(issue, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al actualizar el issue: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
