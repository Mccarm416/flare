package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping("/home")
	public String registration() {
		
		return "/dashboard";
	}
}
