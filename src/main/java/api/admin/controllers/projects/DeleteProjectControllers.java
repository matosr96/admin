package api.admin.controllers.projects;

import api.admin.services.projects.DeleteProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DeleteProjectControllers {
    private final DeleteProjectService deleteProjectService;

    @Autowired
    public DeleteProjectControllers(DeleteProjectService deleteProjectService) {
        this.deleteProjectService = deleteProjectService;
    }

    @DeleteMapping(value = "/projects/{uuid}", headers = "Accept=application/json")
    public ResponseEntity<?> deleteProjectRoute(@PathVariable("uuid") String uuid) {
        try {
            boolean response = deleteProjectService.deleteProject(uuid);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al eliminar el proyecto: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
