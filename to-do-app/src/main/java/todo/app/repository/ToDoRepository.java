package todo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.app.entity.Task;

public interface ToDoRepository extends JpaRepository<Task, Long> {

}
