package flare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import flare.model.mail.Mailer;
import flare.model.users.ClubLeader;
import flare.model.users.Student;

@Controller
public class AccountManagementController {
	
	@Autowired
	Mailer mailer;

	@GetMapping("/ticket")
	public ModelAndView postTicket() {
		
		ModelAndView tickets = new ModelAndView("/submitTicket");
		
		return tickets;
	}
	
	@PostMapping("/ticket")
	public ModelAndView getTicket(@RequestParam("message") String message,
			@RequestParam("subject") String subject) {
		
		ModelAndView tickets = new ModelAndView("/submitTicket");
		
		mailer.ticketMail(subject, message);
		
		tickets.addObject("msg","Your ticket has been submitted succesfully!");
		
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
