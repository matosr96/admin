package api.admin.controllers.projects;

import api.admin.models.dtos.project.CreateProjectDTO;
import api.admin.models.dtos.project.UpdateProjectDTO;
import api.admin.models.entities.Project;
import api.admin.services.projects.GetActiveProjectsService;
import api.admin.services.projects.UpdateProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UpdateProjectController {
    private final UpdateProjectService updateProjectService;

    @Autowired
    public UpdateProjectController(UpdateProjectService updateProjectService) {
        this.updateProjectService = updateProjectService;
    }

    @PutMapping(value = "/projects", headers = "Accept=application/json")
    public ResponseEntity<?> updateProjectRoute(@RequestBody UpdateProjectDTO updateProjectDTO) {
        try {
            Project project = updateProjectService.updateProject(updateProjectDTO);
            return new ResponseEntity<>(project, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al obtener los proyecto: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
