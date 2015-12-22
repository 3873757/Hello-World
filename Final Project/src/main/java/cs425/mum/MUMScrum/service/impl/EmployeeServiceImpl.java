package cs425.mum.MUMScrum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs425.mum.MUMScrum.domain.Employee;
import cs425.mum.MUMScrum.domain.User;
import cs425.mum.MUMScrum.repository.EmployeeRepository;
import cs425.mum.MUMScrum.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee employee) {
		
		Employee previousEmployee = employeeRepository.findOne(employee.getId());
		if(previousEmployee!=null){
			employee.setUser(previousEmployee.getUser());
		}else{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			User user = employee.getUser();
			String hashedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(hashedPassword);
		}
		employeeRepository.save(employee);
	}

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Employee> getAllEmployees() {
		return (List<Employee>)employeeRepository.findAll();
	}

	public Employee getEmployeeById(long id) {
		return employeeRepository.findOne(id);
	}

	
	public void deleteEmployeeById(long id) {
		employeeRepository.delete(id);
	}

}
