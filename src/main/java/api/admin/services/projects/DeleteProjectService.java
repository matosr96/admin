package api.admin.services.projects;

import api.admin.models.entities.Project;
import api.admin.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeleteProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public DeleteProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public boolean deleteProject(String uuid){
        try {
            List<Project> projectList = projectRepository.findAll();
            Project projectFound = null;
            for (Project project : projectList) {
                if (project.getUuid().equals(uuid)) {
                    projectFound = project;
                    break;
                }
            }
            if (projectFound != null) {
                projectRepository.delete(projectFound);
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
