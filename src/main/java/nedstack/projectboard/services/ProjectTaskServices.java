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
        if(projectTask.getStatus() == null || projectTask.getStatus() == "") {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }
     public Iterable<ProjectTask> findAll(){
        return  projectTaskRepository.findAll();
     }
     public ProjectTask findById(Long id) {
        return  projectTaskRepository.getById(id);
     }
}
