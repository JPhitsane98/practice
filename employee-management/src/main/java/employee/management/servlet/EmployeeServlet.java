package employee.management.servlet;

import employee.management.service.EmployeeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/employees")
public class EmployeeServlet extends HttpServlet {
    @Inject
    private EmployeeService employeeService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests (e.g., fetching employee details)
        // Extract parameters, retrieve data from database, format response, etc.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests (e.g., adding or updating an employee)
        // Extract parameters, validate data, save to database, etc.
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle PUT requests (e.g., updating an employee)
        // Extract parameters, validate data, update resource in database, etc.
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle DELETE requests (e.g., deleting an employee)
        // Extract parameters, delete resource from database, etc.
    }
}
