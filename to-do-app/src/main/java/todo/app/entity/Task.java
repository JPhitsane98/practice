package todo.app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate due;
    private final LocalDate created = LocalDate.now();
    private boolean done;

    @Override
    public String toString(){
        return "Task: " + name + " due on: " + due;
    }
}
