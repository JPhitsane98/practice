package employee.management.service.impl;

import employee.management.dao.EmployeeDAO;
import employee.management.dto.EmployeeDTO;
import employee.management.service.EmployeeService;

import javax.ejb.Remote;
import javax.inject.Inject;
import java.util.List;
@Remote
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeDAO employeeDAO;
    @Override
    public int save(EmployeeDTO employeeDTO) {
        return employeeDAO.save(employeeDTO);
    }

    @Override
    public int delete(Long id) {
        return employeeDAO.delete(id);
    }

    @Override
    public int update(Long id, EmployeeDTO employeeDTO) {
        return employeeDAO.update(id, employeeDTO);
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
