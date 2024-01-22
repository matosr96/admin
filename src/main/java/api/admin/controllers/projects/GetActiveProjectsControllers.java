package api.admin.controllers.projects;

import api.admin.models.entities.Project;
import api.admin.services.projects.GetActiveProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GetActiveProjectsControllers {
    private final GetActiveProjectsService getActiveProjectsService;

    @Autowired
    public GetActiveProjectsControllers(GetActiveProjectsService getActiveProjectsService) {
        this.getActiveProjectsService = getActiveProjectsService;
    }

    @GetMapping(value = "/projects", headers = "Accept=application/json")
    public ResponseEntity<?> getProjectRoute() {
        try {
           List<Project> projects = getActiveProjectsService.getActiveProjects();
            return new ResponseEntity<>(projects, HttpStatus.CREATED);
        } catch (Exception ex) {
            String errorMessage = "Error interno al obtener los proyecto: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
