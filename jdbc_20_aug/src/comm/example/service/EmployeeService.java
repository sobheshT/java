package comm.example.service;

import java.util.List;

import comm.example.model.Employee;

public interface EmployeeService {
public void createemployee(Employee employee);
public List<Employee> getAllEmployees();
public Employee getEmployeeById(int id);
}