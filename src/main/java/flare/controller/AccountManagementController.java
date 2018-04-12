package flare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import flare.model.users.ClubLeader;
import flare.model.users.Student;
import flare.model.users.User;

@Controller
public class AccountManagementController {

	@RequestMapping("/ticket")
	public ModelAndView submitTicket() {
		
		ModelAndView tickets = new ModelAndView("/submitTicket");
		
		return tickets;
	}
	
	@RequestMapping("/accountManagement")
	public ModelAndView accountManagement(HttpSession session,
			HttpServletRequest req) {
		
		
		if(req.isUserInRole("ROLE_STUDENT")) {
			
			ModelAndView accountManagement = new ModelAndView("/accountManagement");
			
			 Student user = (Student)req.getSession().getAttribute("user");
			 
			 accountManagement.addObject(user);
			 
			 return accountManagement;
			
		}
		else if(req.isUserInRole("ROLE_CL")) {
			
			ModelAndView accountManagement = new ModelAndView("/accountManagement");
			
			ClubLeader user = (ClubLeader)req.getSession().getAttribute("user");
			
			accountManagement.addObject(user);
			
			return accountManagement;
		}
		
		ModelAndView accountManagement = new ModelAndView("/accountManagement");
		return accountManagement;
		
		
	}
}
