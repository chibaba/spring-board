package nedstack.projectboard.services;

import nedstack.projectboard.domain.ProjectTask;
import nedstack.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServices {
    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {
        return projectTaskRepository.save(projectTask);
    }
}
