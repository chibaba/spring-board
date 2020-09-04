package nedstack.projectboard.web;

import nedstack.projectboard.domain.ProjectTask;
import nedstack.projectboard.services.ProjectTaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
    @Autowired
    private ProjectTaskServices projectTaskServices;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@RequestBody ProjectTask projectTask) {
        ProjectTask newPT = projectTaskServices.saveOrUpdateProjectTask(projectTask);
        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
    }
}
