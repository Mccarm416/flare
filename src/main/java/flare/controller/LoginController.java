package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
}
