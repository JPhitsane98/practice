package todo.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.app.dto.TaskDTO;
import todo.app.entity.Task;
import todo.app.repository.ToDoRepository;
import todo.app.service.ToDoService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public String add(TaskDTO dto) {
        if (dto != null) {
            Task task = toDoRepository.save(convertToEntity(dto));
            return "Successfully Added " + task;
        }
        return "Could not save task";
    }

    @Override
    public String delete(Long id) {
        if (toDoRepository.findById(id).isPresent()) {
            Task task = toDoRepository.findById(id).get();
            toDoRepository.delete(task);
            return "Successfully Deleted " + task;
        }
        return "Could not delete Task";
    }

    @Override
    public String update(Long id, TaskDTO dto) {
        if (toDoRepository.findById(id).isPresent()) {
            Task existingTask = toDoRepository.findById(id).get();
            existingTask.setName(dto.getName());
            existingTask.setDescription(dto.getDescription());
            existingTask.setDue(dto.getDue());
            toDoRepository.save(existingTask);
            return "Successfully Updated " + dto;
        }
        return "Could not update Task";
    }

    @Override
    public String close(Long id) {
        if (toDoRepository.findById(id).isPresent()) {
            Task task = toDoRepository.findById(id).get();
            task.setDone(true);
            toDoRepository.save(task);
            return "Congratulations Completed " + task;
        }
        return "Could not Close Task";
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = toDoRepository.findAll();
        return tasks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TaskDTO convertToDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setDue(task.getDue());
        dto.setDone(task.isDone());
        dto.setCreated(task.getCreated());
        return dto;
    }

    private Task convertToEntity(TaskDTO dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setDue(dto.getDue());
        return task;
    }
}
