package cs425.mum.MUMScrum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs425.mum.MUMScrum.domain.AssignRole;
import cs425.mum.MUMScrum.domain.Employee;
import cs425.mum.MUMScrum.domain.Role;
import cs425.mum.MUMScrum.service.EmployeeService;
import cs425.mum.MUMScrum.service.RoleService;

@Controller
public class AssignRoleController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "employees/assignRole/{id}", method = RequestMethod.GET)
	public String getAssignRoleForm(@PathVariable("id")long id,  Model model){
		AssignRole empRole = new AssignRole();
		Employee e= employeeService.getEmployeeById(id);
		empRole.setEmployee(e);
		empRole.setRole(new Role());
		model.addAttribute("empRole", empRole);
		model.addAttribute("roles", roleService.findAllRoles());
		model.addAttribute("userRoles", e.getUser().getRoles());
		return "employee/assignRole";
	}
	
	@RequestMapping(value = "employees/assignRole/{id}", method = RequestMethod.POST)
	public String processAssigRoleForm(@Valid @ModelAttribute("empRole") AssignRole empRole, Model model){
		Employee employee = employeeService.getEmployeeById(empRole.getEmployee().getId());
		Role role = roleService.findRoleById(empRole.getRole().getId());
		roleService.assignRole(employee, role);
		model.addAttribute("success", messageSource.getMessage("action.success", null, null));
		return "success";
	}
}
