package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountManagementController {

	@RequestMapping("/ticket")
	public ModelAndView submitTicket() {
		
		ModelAndView tickets = new ModelAndView("/submitTicket");
		
		return tickets;
	}
	
	@RequestMapping("/accountManagement")
	public ModelAndView accountManagement() {
		
		ModelAndView accountManagement = new ModelAndView("/accountManagement");
		
		return accountManagement;
	}
}
