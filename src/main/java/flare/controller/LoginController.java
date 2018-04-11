package flare.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import flare.factory.AdminFactory;
import flare.factory.ClubLeaderFactory;
import flare.factory.StudentFactory;
import flare.model.users.Admin;
import flare.model.users.ClubLeader;
import flare.model.users.Student;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	/**
	 * 
	 * @return maps login page to /login url
	 */
	@GetMapping("/login")
	public String login() {
		
		return "loginPage";
		
	}


	@ExceptionHandler(Exception.class)
	public String adminnException() {
		
		return "/login";
	}
	
	@RequestMapping("/welcome")
	public String init(Principal principal, 
			HttpServletRequest req,
			 HttpSession session) throws Exception {
		
		if(req.isUserInRole("ROLE_ADMIN")) {
			
			AdminFactory af = new AdminFactory();
			Admin admin = af.getObject();
			
			admin.DB().bindObjectToDB(principal.getName());
			session.setAttribute("user", admin);
			System.out.println("Administrator found ...");
			
			return "adminPanel";
		}
		
		else if(req.isUserInRole("ROLE_CL")) {
			
			ClubLeaderFactory cf = new ClubLeaderFactory();
			ClubLeader cl = cf.getObject();
			
			cl.DB().bindObjectToDB(principal.getName());
			session.setAttribute("user", cl);
			System.out.println("Club Leader found ...");
		}
		
		else if(req.isUserInRole("ROLE_STUDENT")) {
			
			StudentFactory sf = new StudentFactory();
			Student student = sf.getObject();
			
			student.DB().bindObjectToDB(principal.getName());
			session.setAttribute("user", student);
			System.out.println("Student found ...");
		}
		System.out.println(principal.getName());
		
		return "dashboard";
	}
}
