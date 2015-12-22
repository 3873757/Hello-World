package cs425.mum.MUMScrum.controller;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs425.mum.MUMScrum.domain.Employee;
import cs425.mum.MUMScrum.domain.Role;
import cs425.mum.MUMScrum.service.EmployeeService;
import cs425.mum.MUMScrum.service.RoleService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = {"/", "/edit", "/list"}, method = RequestMethod.GET)
	public String listEmployees(Model model){
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employee/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreateEmployeeForm(@ModelAttribute("newEmployee") Employee newEmployee){
		return "employee/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String ProcessCreateEmployeeForm(@Valid @ModelAttribute("newEmployee") Employee newEmployee, 
					BindingResult bindingResult, RedirectAttributes red){
		if(bindingResult.hasErrors())
			return "employee/create";
		employeeService.saveEmployee(newEmployee);
		red.addFlashAttribute("employeeDetail", newEmployee);
		return "redirect:/employees/detail";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getupdateEmployeeForm(@PathVariable("id") long id, Model model){
		model.addAttribute("editEmployee", employeeService.getEmployeeById(id));
		return "employee/edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String processupdateEmployeeForm(@Valid @ModelAttribute("editEmployee") Employee employeeToBeUpdated,
					 BindingResult bindingResult, RedirectAttributes red){
		if(bindingResult.hasErrors())
			return "employee/edit";
		employeeService.saveEmployee(employeeToBeUpdated);
		red.addFlashAttribute("employees", employeeService.getAllEmployees());
		return "redirect:/employees/list";
	}
		
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String employeeDelete(@PathVariable("id") long id, RedirectAttributes red){
		Employee employeeToBeDeleted =  employeeService.getEmployeeById(id);

		int response = JOptionPane.showConfirmDialog(null, messageSource.getMessage("confirm.want.to.delete", null, null)
				+ " " + messageSource.getMessage("confirm.delete.employee", null, null)+ " " + employeeToBeDeleted.getFirstName() + " " + employeeToBeDeleted.getLastName() + " ?"
				, messageSource.getMessage("delete", null,null), JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			employeeService.deleteEmployeeById(id);			
		}		
		red.addFlashAttribute("employees", employeeService.getAllEmployees());
		return "redirect:/employees/list";
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String employeeDetail(){
		return "employee/detail";
	}
	
}
