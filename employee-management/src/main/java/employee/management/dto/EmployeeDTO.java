package employee.management.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EmployeeDTO {

    private String employeeNumber;
    private String name;
    private String lastName;
    private LocalDate dob;
    private LocalDate startDate;
    private EMPLOYMENTYPE employmentype;
    private String position;
}
