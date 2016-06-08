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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs425.mum.MUMScrum.domain.Role;
import cs425.mum.MUMScrum.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MessageSource  messageSource;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model){
		model.addAttribute("roles", roleService.findAllRoles());
		return "role/roleHomePage";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listRoles(Model model){
		model.addAttribute("roles", roleService.findAllRoles());
		return "role/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreateRoleForm(@ModelAttribute("newRole") Role newrole){
		return "role/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String ProcessCreateRoleForm(@Valid @ModelAttribute("newRole") Role newRole, 
					BindingResult bindingResult, RedirectAttributes red){
		if(bindingResult.hasErrors())
			return "role/create";
		roleService.saveRole(newRole);
		red.addFlashAttribute("roleDetail", newRole);
		return "redirect:/roles/detail";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getUpdateRoleForm(@PathVariable("id") long id, Model model){
		model.addAttribute("editRole", roleService.findRoleById(id));
		return "role/edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String processUpdateRoleForm(@Valid @ModelAttribute("editRole") Role roleToBeUpdated,
					 BindingResult bindingResult, RedirectAttributes red){
		if(bindingResult.hasErrors())
			return "role/edit";
		roleService.saveRole(roleToBeUpdated);
		red.addFlashAttribute("roles", roleToBeUpdated);
		return "redirect:/roles/list";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String roleDelete(@PathVariable("id") long id, Model model){
		Role roleToBeDeleted =  roleService.findRoleById(id);

		int response = JOptionPane.showConfirmDialog(null, messageSource.getMessage("confirm.want.to.delete", null, null)
				+ " " + roleToBeDeleted.getName() + "?"
				, messageSource.getMessage("delete", null,null), JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			roleService.deleteRoleById(id);			
		}		
		model.addAttribute("roles", roleService.findAllRoles());
		return "role/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String roleDetail(){
		return "role/detail";
	}
}
