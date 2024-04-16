package todo.app.service;

import org.springframework.stereotype.Service;
import todo.app.dto.TaskDTO;
import todo.app.entity.Task;

import java.util.List;

public interface ToDoService {

    String add(TaskDTO dto);
    String delete(Long id);
    String update(Long id, TaskDTO dto);
    String close(Long id);
    List<TaskDTO> getAllTasks();
}
