package todo.app.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TaskDTO {

    private String name;
    private String description;
    private LocalDate due;
    private LocalDate created;
    private boolean done;

}
