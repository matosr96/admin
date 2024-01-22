package api.admin.services.projects;

import api.admin.models.dtos.project.CreateProjectDTO;
import api.admin.models.entities.Project;
import api.admin.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CreateProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public CreateProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Project createProject(CreateProjectDTO createProjectDTO) {
        Project project = new Project();
        String uuid = UUID.randomUUID().toString();
        project.setUuid(uuid);
        project.setStatus("active");
        project.setName(createProjectDTO.getName());
        project.setUser(createProjectDTO.getUser());
        project.setClient(createProjectDTO.getClient());
        project.setCategory(createProjectDTO.getCategory());
        project.setStartDate(createProjectDTO.getStartDate());
        project.setTargetDate(createProjectDTO.getTargetDate());
        project.setProgress(createProjectDTO.getProgress());
        project.setResources(createProjectDTO.getResources());
        project.setDescription(createProjectDTO.getDescription());
        project.setLead(createProjectDTO.getLead());
        project.setMembers(createProjectDTO.getMembers());

        return projectRepository.save(project);
    }
}
