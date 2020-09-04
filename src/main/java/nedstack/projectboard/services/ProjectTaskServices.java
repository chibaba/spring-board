package nedstack.projectboard.services;

import nedstack.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServices {
    @Autowired
    private ProjectTaskRepository projectTaskRepository;
}
