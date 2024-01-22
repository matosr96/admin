package api.admin.controllers.issues;

import api.admin.services.issue.DeleteIssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DeleteIssueController {
    private final DeleteIssueService deleteIssueService;
    public DeleteIssueController(DeleteIssueService deleteIssueService) {
        this.deleteIssueService = deleteIssueService;
    }

    @DeleteMapping(value = "/issues/{uuid}", headers = "Accept=application/json")
    public ResponseEntity<?> deleteIssueRoute(@PathVariable("uuid") String uuid) {
        try {
            boolean response = deleteIssueService.deleteIssue(uuid);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al eliminar la issue: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
