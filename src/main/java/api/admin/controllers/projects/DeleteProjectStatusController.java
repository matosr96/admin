package api.admin.controllers.projects;

import api.admin.models.entities.Project;
import api.admin.services.projects.DeleteProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DeleteProjectStatusController {
    private final DeleteProjectStatusService updateStatusToDeletedService;

    @Autowired
    public DeleteProjectStatusController(DeleteProjectStatusService updateStatusToDeletedService) {
        this.updateStatusToDeletedService = updateStatusToDeletedService;
    }

    @PutMapping(value = "/projects/{uuid}", headers = "Accept=application/json")
    public ResponseEntity<?> updateStatusToDeletedRoute(@PathVariable("uuid") String uuid) {
        try {
            Project project = updateStatusToDeletedService.updateStatusToDelete(uuid);
            return new ResponseEntity<>(project, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al actualizar el proyecto: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
