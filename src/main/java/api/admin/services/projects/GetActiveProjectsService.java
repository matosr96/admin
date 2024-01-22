package api.admin.services.projects;

import api.admin.models.entities.Project;
import api.admin.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetActiveProjectsService {
    private final ProjectRepository projectRepository;

    @Autowired
    public GetActiveProjectsService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getActiveProjects(){
        List<Project> projectList = projectRepository.findAll();
        List<Project> activeProjects = new ArrayList<>();

        for (Project project : projectList) {
            if (project.getStatus().equals("active")) {
                activeProjects.add(project);
            }
        }

        return activeProjects;
    }

}
