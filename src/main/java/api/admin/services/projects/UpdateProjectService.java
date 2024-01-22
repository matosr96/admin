package api.admin.services.projects;

import api.admin.models.dtos.project.UpdateProjectDTO;
import api.admin.models.entities.Project;
import api.admin.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UpdateProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public UpdateProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Project updateProject(UpdateProjectDTO updateProjectDTO){
        try {
            List<Project> projectList = projectRepository.findAll();
            Project projectFound = null;
            for (Project project : projectList) {
                if (project.getUuid().equals(updateProjectDTO.getUuid())) {
                    projectFound = project;
                    break;
                }
            }
            if (projectFound != null) {
                projectFound.setName(updateProjectDTO.getName());
                projectFound.setClient(updateProjectDTO.getClient());
                projectFound.setCategory(updateProjectDTO.getCategory());
                projectFound.setStartDate(updateProjectDTO.getStartDate());
                projectFound.setTargetDate(updateProjectDTO.getTargetDate());
                projectFound.setProgress(updateProjectDTO.getProgress());
                projectFound.setResources(updateProjectDTO.getResources());
                projectFound.setDescription(updateProjectDTO.getDescription());
                projectFound.setMembers(updateProjectDTO.getMembers());
                projectFound.setLead(updateProjectDTO.getLead());
                return projectRepository.save(projectFound);
            } else {
                return null;
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
