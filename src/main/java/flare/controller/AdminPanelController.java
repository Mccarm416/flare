package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPanelController {

	@RequestMapping("/adminstration")
	public String registration() {
		
		return "/adminPanel";
	}
}
