package nedstack.projectboard.web;

import nedstack.projectboard.services.ProjectTaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
    @Autowired
    private ProjectTaskServices projectTaskServices;
}
