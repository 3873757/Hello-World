package cs425.mum.MUMScrum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs425.mum.MUMScrum.domain.ReleaseBacklog;
import cs425.mum.MUMScrum.service.ReleaseBacklogservice;

@Controller
@RequestMapping({"/ReleaseBacklogs"})
public class ReleaseBacklogController {
	@Autowired
	private ReleaseBacklogservice ReleaseBacklogservice;
	
		
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String productBacklog(Model model){
		model.addAttribute("ReleaseBacklogs", ReleaseBacklogservice.getAllReleaseBacklogs());
		return "productBacklog/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String ProductBacklogForm(@ModelAttribute("newProductBackLog") ReleaseBacklog newProductBacklog){
		return "productBacklog/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String ProductBacklogForm(@Valid @ModelAttribute("newProductBackLog") ReleaseBacklog newProductBacklog, 
							BindingResult bindingResult,
							RedirectAttributes red){
		//red=null;
		if(bindingResult.hasErrors())
			return "productBacklog/create";
		ReleaseBacklogservice.saveProductBacklog(newProductBacklog);
		red.addFlashAttribute("productBacklogDetail", newProductBacklog);
		return "redirect:/ReleaseBacklogs/detail";
	}
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
	public @ResponseBody String ProductBacklogDelete(@PathVariable("id") long id){
		//javax.swing.JOptionPane.showMessageDialog(null, id);
		this.ReleaseBacklogservice.deleteProductBacklogById(id);
		return "Successfully deleted.";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String ProductBackLogReleaseDetail(){
		return "productBacklog/detail";
	}
	
	
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getUpdateEmployeeForm(@RequestParam("id") long id, Model model){
		model.addAttribute("editProductBackLog", ReleaseBacklogservice.getProductBacklogId(id));
		return "productBacklog/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String processUpdateEmployeeForm(@Valid @ModelAttribute("editProductBackLog") ReleaseBacklog updateProductBacklog,
					 BindingResult bindingResult, RedirectAttributes red){
		if(bindingResult.hasErrors())
			return "productBacklog/edit";
		ReleaseBacklogservice.saveProductBacklog(updateProductBacklog);
		red.addFlashAttribute("ReleaseBacklogs", updateProductBacklog);
		return "redirect:/ReleaseBacklogs/list";
	}
	
			
}
