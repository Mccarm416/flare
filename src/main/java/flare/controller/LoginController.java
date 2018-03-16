package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	/**
	 * 
	 * @return maps login page to /login url
	 */
	@RequestMapping("/login")
	public String login() {
		
		return "loginPage";
		
	}

}
