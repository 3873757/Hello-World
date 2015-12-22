package cs425.mum.MUMScrum.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Model model, Principal principal){
		model.addAttribute("username", principal.getName());
		return "welcome";
	}
	@RequestMapping(value = "/welcome2", method = RequestMethod.GET)
	public String welcome2(Model model, Principal principal){
		model.addAttribute("username", principal.getName());
		return "welcome2";
	}
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String accessdeniedPage() {
        return "accessdenied";
    }
}
