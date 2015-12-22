package cs425.mum.MUMScrum.service;

import java.util.List;
import cs425.mum.MUMScrum.domain.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long id);
	public void deleteEmployeeById(long id);
}
