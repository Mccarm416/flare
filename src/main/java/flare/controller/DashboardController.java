package flare.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class DashboardController {

	@RequestMapping("/home")
	public String registration(Model model, Principal principal) {
		
		System.out.println(principal.getName());
		
		
		return "/dashboard";
	}
}
