package flare.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import flare.factory.AdminFactory;
import flare.factory.ClubLeaderFactory;
import flare.factory.StudentFactory;
import flare.model.users.Admin;
import flare.model.users.ClubLeader;
import flare.model.users.Student;

@Controller
@SessionAttributes("user")
public class DashboardController {

	
	@RequestMapping("/home")
	public String registration() {
		
		return "/dashboard";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView registrationException() {
		
		ModelAndView errorModel = new ModelAndView("/login");
		
		return errorModel;
		
	}
}
