package cs425.mum.MUMScrum.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs425.mum.MUMScrum.domain.ProductBackLogRelease;
import cs425.mum.MUMScrum.domain.ReleaseBacklog;
import cs425.mum.MUMScrum.service.ProductBackLogReleaseService;
import cs425.mum.MUMScrum.service.ReleaseBacklogservice;
import cs425.mum.MUMScrum.service.UserStoryService;

@Controller
@RequestMapping({ "/ProductBackLogReleases" })
public class ProductBackLogReleaseController {

	@Autowired
	private ProductBackLogReleaseService ProductBackLogReleaseService;

	@Autowired
	ReleaseBacklogservice pBacklog;
	
	@Autowired
	UserStoryService userStoryService;

	@RequestMapping(value={"/", "/list" })
	public String listProductBackLogReleases(Model model) {
		model.addAttribute("productbacklogreleases", ProductBackLogReleaseService.getAllProductBackLogReleases());
		return "ProductBackLogRelease/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreateProductBackLogReleaseForm(ProductBackLogRelease newProductBackLogRelease, Model model) {
		model.addAttribute("ReleaseBacklogs", pBacklog.getAllReleaseBacklogs());
		model.addAttribute("UserStories", userStoryService.getAllUserStories());
		model.addAttribute("newProductBackLogRelease", newProductBackLogRelease);
		return "ProductBackLogRelease/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String processcreateProductBackLogReleaseForm(
			@Valid @ModelAttribute("newProductBackLogRelease") ProductBackLogRelease ProductBackLogReleaseToBecreateed,
			BindingResult bindingResult, RedirectAttributes red) {
		//System.out.println(id);
		if (bindingResult.hasErrors())
			return "ProductBackLogRelease/create";
		

		red.addFlashAttribute("ReleaseBackLogDetail", ProductBackLogReleaseToBecreateed);
		ProductBackLogReleaseToBecreateed.setPBacklog(pBacklog.getProductBacklogId(ProductBackLogReleaseToBecreateed.getproductId()));
		ProductBackLogReleaseService.saveProductBackLogRelease(ProductBackLogReleaseToBecreateed);
		return "redirect:/ProductBackLogReleases/detail";

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getUpdateProductBackLogReleaseForm(@RequestParam("id") long id, Model model) {
		model.addAttribute("editProductBackLogRelease",
				ProductBackLogReleaseService.getAllProductBackLogReleasesById(id));
		return "ProductBackLogRelease/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String processUpdateProductBackLogReleaseForm(
			@Valid @ModelAttribute("editProductBackLogRelease") ProductBackLogRelease updateRelease,
			BindingResult bindingResult, RedirectAttributes red) {
		if (bindingResult.hasErrors())
			return "ProductBackLogRelease/edit";
		ProductBackLogReleaseService.saveProductBackLogRelease(updateRelease);
		red.addFlashAttribute("ProductBackLogReleases", updateRelease);
		return "redirect:/ProductBackLogReleases/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String ProductBackLogReleaseDelete(@RequestParam("id") long id, Model model) {
		ProductBackLogReleaseService.deleteProductBackLogReleaseById(id);
		model.addAttribute("ProductBackLogReleases", ProductBackLogReleaseService.getAllProductBackLogReleases());
		return "redirect:/ProductBackLogReleases/list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String ProductBackLogReleaseDetail() {
		return "ProductBackLogRelease/detail";
	}
}