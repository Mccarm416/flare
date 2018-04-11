package flare.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPanelController {

	@RequestMapping("/admin")
	public String registration() {
		
		return "/adminPanel";
	}
	
	@ExceptionHandler(Exception.class)
	public String adminnException() {
		
		return "/adminPanel";
		
	}
	
	@RequestMapping("/forbidden")
	public String forbidden() {
		
		return "403";
	}
}
