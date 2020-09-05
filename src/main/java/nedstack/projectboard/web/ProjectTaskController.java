package nedstack.projectboard.web;

import nedstack.projectboard.domain.ProjectTask;
import nedstack.projectboard.services.ProjectTaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
    @Autowired
    private ProjectTaskServices projectTaskServices;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody ProjectTask projectTask, BindingResult result) {
        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        ProjectTask newPT = projectTaskServices.saveOrUpdateProjectTask(projectTask);
        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public Iterable <ProjectTask> getAllPTs() {
        return projectTaskServices.findAll();
    }
    @GetMapping("/{pt_id}")
    public ResponseEntity<?>  getPTById(@PathVariable Long pt_id) {
        ProjectTask  projectTask = projectTaskServices.findById(pt_id);
                return  new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
    }
}
