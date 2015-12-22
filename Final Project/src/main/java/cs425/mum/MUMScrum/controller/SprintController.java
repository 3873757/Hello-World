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

import cs425.mum.MUMScrum.domain.Sprint;
import cs425.mum.MUMScrum.service.EmployeeService;
import cs425.mum.MUMScrum.service.ProductBackLogReleaseService;
import cs425.mum.MUMScrum.service.ReleaseBacklogservice;
import cs425.mum.MUMScrum.service.SprintService;


@Controller
@RequestMapping({"/sprints"})
public class SprintController {
	
	@Autowired
	private SprintService sprintService;
	
	
	@Autowired
	ProductBackLogReleaseService pBackLogRelease;
	
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = {"/", "/edit", "/list"})
	public String listsprints(Model model) {
		model.addAttribute("sprints", sprintService.getAllSprints());
		return "sprint/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreateSprintForm(@ModelAttribute("newSprint") Sprint newSprint, Model model) {
		
		model.addAttribute("ProductBackLogReleases", pBackLogRelease.getAllProductBackLogReleases());
		model.addAttribute("releases", employeeService.getAllEmployees());
		return "sprint/create";
	}
	   
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String processAddnewSprintForm(@Valid @ModelAttribute("newSprint") Sprint sprintToBeAdded, 
			 BindingResult result) {
		if(result.hasErrors())
			return "sprint/create";
   		try {
   			sprintToBeAdded.setRelease(pBackLogRelease.getAllProductBackLogReleasesById(sprintToBeAdded.getReleaseId()));  			
			sprintService.saveSprint(sprintToBeAdded);
				
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
		}
	   	return "redirect:/sprints/list";
	}
	
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public String getSprintToUpdate(@PathVariable("id") long id,Model model){
//		model.addAttribute("editSprint", sprintService.findSprintById(id));
//		model.addAttribute("releases", employeeService.getAllEmployees());
//		return "sprint/edit";
//	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getSprintToUpdate(@RequestParam("id") long id, Model model) {
		model.addAttribute("editSprint", sprintService.findSprintById(id));
		model.addAttribute("releases", employeeService.getAllEmployees());
		return "sprint/edit";
		//return "ProductBackLogRelease/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String processUpdateSprint(@Valid @ModelAttribute("editSprint") Sprint updateSprint, Model model){
		sprintService.saveSprint(updateSprint);
		model.addAttribute("sprints", sprintService.getAllSprints());
		return "redirect:/sprints/list";
}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String sprintDelete(@PathVariable("id") long id, Model model){
		Sprint sprintToBeDeleted =  sprintService.findSprintById(id);

		int response = JOptionPane.showConfirmDialog(null, messageSource.getMessage("confirm.delete", null, null)
				+" " + messageSource.getMessage("confirm.delete.sprint", null, null) + " " + sprintToBeDeleted.getName() + "?"
				, messageSource.getMessage("delete", null,null), JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			sprintService.deleteSprintById(id);			
		}		
		model.addAttribute("sprints", sprintService.getAllSprints());
		return "sprint/list";
	}
	
	
}