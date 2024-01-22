package api.admin.controllers.projects;

import api.admin.models.dtos.project.CreateProjectDTO;
import api.admin.models.entities.Project;
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
public class CreateProjectController {
    private final CreateProjectService createProjectService;

    @Autowired
    public CreateProjectController(CreateProjectService createProjectService) {
        this.createProjectService = createProjectService;
    }

    @PostMapping(value = "/projects", headers = "Accept=application/json")
    public ResponseEntity<?> createProject(@RequestBody CreateProjectDTO createProjectDTO) {
        try {
            Project createdProject = createProjectService.createProject(createProjectDTO);
            return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al crear el proyecto: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
