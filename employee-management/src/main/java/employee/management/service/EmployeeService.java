package employee.management.service;

import employee.management.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    int save(EmployeeDTO employeeDTO);
    int delete(Long id);
    int update(Long id, EmployeeDTO employeeDTO);
    EmployeeDTO getEmployee(Long id);
    List<EmployeeDTO> getAllEmployees();
}
