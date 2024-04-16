package employee.management.dao;

import employee.management.dto.EMPLOYMENTYPE;
import employee.management.dto.EmployeeDTO;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(){
        try {
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);
        }catch (IOException e){
            System.out.println("Failed to load file: "+ e.getMessage());
        }catch (SQLException e){
            System.out.println("Failed to get database connection: "+ e.getMessage());
        }
    }

    public int save(EmployeeDTO employeeDTO){
        String sql = "insert into Employee (name, last_name, dob, start_date, employee_number, employment_type, position) values " +
                "('"+employeeDTO.getName()+"', '"+employeeDTO.getLastName()+"', "+employeeDTO.getDob()+", "+ employeeDTO.getStartDate()+", '"+ employeeDTO.getEmployeeNumber()+
                "', '"+ employeeDTO.getEmploymentype()+"', '"+ employeeDTO.getPosition()+"')";
        int numRows = 0;
        try (Statement statement = connection.createStatement()) {
            numRows = statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("Failed to save employee: "+ e.getMessage());
        }
        return numRows;
    }

    public int delete(Long id){
        String sql = "delete from Employee where id = " + id;
        int numRows = 0;
        try (Statement statement = connection.createStatement()) {
            numRows = statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("Failed to delete employee: "+ e.getMessage());
        }
        return numRows;
    }

    public int update(Long id, EmployeeDTO employeeDTO){
        String sql = "update Employee set name = '"+employeeDTO.getName()+"'," +
                " last_name = '"+employeeDTO.getLastName()+"', dob = "+employeeDTO.getDob()+
                "', start_date = "+employeeDTO.getStartDate()+", employee_number = '"+employeeDTO.getEmployeeNumber()+
                ", employment_type = '"+employeeDTO.getEmploymentype()+"', position = '"+employeeDTO.getPosition()+"' where id = " + id;
        int numRows = 0;
        try (Statement statement = connection.createStatement()) {
            numRows = statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("Failed to update employee: "+ e.getMessage());
        }
        return numRows;
    }

    public EmployeeDTO getEmployee(Long id){
        String sql = "Select * from Employee where employee_number = " + id;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        try (Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql)){

            if (resultSet.next()) {
                employeeDTO = getEmployeeDTO(resultSet);
            }
        }catch(SQLException e){
            System.out.println("Failed to query database: "+ e.getMessage());
        }
        return employeeDTO;
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeDTO> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                EmployeeDTO employeeDTO = getEmployeeDTO(resultSet);
                // Set other task fields as needed
                employees.add(employeeDTO);
            }
        }catch (SQLException e){
            System.out.println("Failed to query database: "+ e.getMessage());
        }
        return employees;
    }

    private static EmployeeDTO getEmployeeDTO(ResultSet resultSet) throws SQLException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeNumber(resultSet.getString("employee_number"));
        employeeDTO.setName(resultSet.getString("name"));
        employeeDTO.setLastName(resultSet.getString("last_name"));
        employeeDTO.setDob(resultSet.getDate("dob").toLocalDate());
        employeeDTO.setStartDate(resultSet.getDate("start_date").toLocalDate());
        employeeDTO.setEmploymentype(EMPLOYMENTYPE.valueOf(resultSet.getString("employment_type")));
        employeeDTO.setPosition(resultSet.getString("position"));
        return employeeDTO;
    }
}
