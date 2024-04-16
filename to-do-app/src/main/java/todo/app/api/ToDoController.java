package todo.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.app.dto.TaskDTO;
import todo.app.service.ToDoService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<TaskDTO> getAllTasks(){
        TaskDTO dto = new TaskDTO();
        dto.setName("name");
        dto.setDescription("description");
        dto.setDue(LocalDate.now());
        return Arrays.asList(dto);
//        return toDoService.getAllTasks();
    }

    @PostMapping("save")
    public String create(@RequestBody TaskDTO task){
        return toDoService.add(task);
    }
}
