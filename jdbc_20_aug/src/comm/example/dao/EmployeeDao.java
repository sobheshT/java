package comm.example.dao;

import comm.example.model.Employee;

import java.util.List;

public interface EmployeeDao {
public void createEmployee(Employee employee);
public List<Employee> getAllEmployees();
public Employee getEmployeeById(int id);
}
