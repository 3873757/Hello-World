package cs425.mum.MUMScrum.controller;

import javax.servlet.http.HttpServletRequest;
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

import cs425.mum.MUMScrum.domain.ProductBackLogRelease;
import cs425.mum.MUMScrum.domain.ReleaseBacklog;
import cs425.mum.MUMScrum.domain.Sprint;
import cs425.mum.MUMScrum.domain.UserStorys;
import cs425.mum.MUMScrum.service.ProductBackLogReleaseService;
import cs425.mum.MUMScrum.service.SprintService;
import cs425.mum.MUMScrum.service.UserStoryService;

@Controller
@RequestMapping({ "/userStorys" })
public class UserStoryController {

	@Autowired
	private UserStoryService userStoryService;

	@Autowired
	private ProductBackLogReleaseService ProductBackLogReleaseService;

	@Autowired
	private SprintService SprintServiceService;

	
	@RequestMapping(value = {"/list/{releaseid}" }, method = RequestMethod.GET)
	public String userStory(Model model, @PathVariable long releaseid) {
		model.addAttribute("userStory", userStoryService.getAllUserStories());
		model.addAttribute("release", ProductBackLogReleaseService.getAllProductBackLogReleasesById(releaseid));
		return "userStory/list";
	}
	@RequestMapping(value = { "/lists/{sprintid}" }, method = RequestMethod.GET)
	public String SprintuserStory(Model model, @PathVariable long sprintid) {
		model.addAttribute("userStory", userStoryService.getAllUserStories());
		model.addAttribute("sprint", SprintServiceService.findSprintById(sprintid));
		
		return "userStory/list";
	}
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String userStoryList(Model model) {
		model.addAttribute("userStory", userStoryService.getAllUserStories());
		return "userStory/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String userStoryForm(@ModelAttribute("newUserStory") UserStorys newUserStory) {
		return "userStory/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String userStoryForm(@Valid @ModelAttribute("newUserStory") UserStorys newUserStory,
			BindingResult bindingResult, RedirectAttributes red) {
		if (bindingResult.hasErrors())
			return "userStory/create";
		userStoryService.saveUserStory(newUserStory);
		red.addFlashAttribute("userStoryDetail", newUserStory);
		return "redirect:/userStorys/detail";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String userStoryUpdate(@RequestParam("id") long id, Model model) {
		model.addAttribute("updateUserStory", this.userStoryService.getUserStoryId(id));
		return "userStory/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String userStoryUpdate(@Valid @ModelAttribute("updateUserStory") UserStorys UserStory,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "userStory/edit";
		this.userStoryService.saveUserStory(UserStory);
		return "redirect:/userStorys/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
	public @ResponseBody String userStoryDelete(@PathVariable("id") long id) {
		// javax.swing.JOptionPane.showMessageDialog(null, id);
		this.userStoryService.deletegetUserStoryId(id);
		return "Successfully deleted.";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String userStoryDetail() {
		return "userStory/detail";
	}

	@RequestMapping(value = "/edit/{releaseid}", method = RequestMethod.GET)
	public String getUserStoryForm(@RequestParam("id") long id, @RequestParam("Releaseid") long Releaseid,
			Model model) {
		
		long d = 2;
		model.addAttribute("edituserStorys", userStoryService.getUserStoryId(id));

		model.addAttribute("release", ProductBackLogReleaseService.getAllProductBackLogReleasesById(Releaseid));
		model.addAttribute("sprint" ,SprintServiceService.findSprintById(d));
		return "userStory/edit";
	}
	@RequestMapping(value = "/edits/{sprintid}", method = RequestMethod.GET)
	public String getUserStoryForms(@RequestParam("id") long id, @RequestParam("sprintid") long sprintId,
			Model model) {
		model.addAttribute("edituserStorys", userStoryService.getUserStoryId(id));

		model.addAttribute("sprint", SprintServiceService.findSprintById(sprintId));
		model.addAttribute("release" ,ProductBackLogReleaseService.getAllProductBackLogReleasesById(2));
		return "userStory/edit";
	}
	
	
	@RequestMapping(value = "/edit/{releaseid}", method = RequestMethod.POST)
	public String processUpdateUserStoryForm(@ModelAttribute("release") ProductBackLogRelease Releasesss,
			@PathVariable long releaseid, @Valid @ModelAttribute("edituserStorys") UserStorys userStory,
			BindingResult bindingResult, RedirectAttributes red) {
		if (bindingResult.hasErrors())
			return "userStory/edit";
		
		
		UserStorys u = userStoryService.getUserStoryId(userStory.getId());
		userStory.setSprint(u.getSprint());
		
		
		userStory.setProductBacklogRelease(ProductBackLogReleaseService.getAllProductBackLogReleasesById(releaseid));
		userStoryService.saveUserStory(userStory);

		// red.addFlashAttribute("userStorys", userStory);
		return "redirect:/ProductBackLogReleases/list";

	}
	@RequestMapping(value = "/edits/{sprintid}", method = RequestMethod.POST)
	public String processUpdateUserStoryForms(@ModelAttribute("sprint") Sprint Sprints,
			@PathVariable long sprintid, @Valid @ModelAttribute("edituserStorys") UserStorys US,
			BindingResult bindingResult, RedirectAttributes red) {
		if (bindingResult.hasErrors())
			return "userStory/edit";
		
		
		//if(US.getProductBacklogRelease()!=null){
			UserStorys u = userStoryService.getUserStoryId(US.getId());
			US.setProductBacklogRelease(u.getProductBacklogRelease());
		//}
		
		US.setSprint(SprintServiceService.findSprintById(sprintid));
		userStoryService.saveUserStory(US);

		red.addFlashAttribute("userStorys", US);
		return "redirect:/sprints/list";

	}

}