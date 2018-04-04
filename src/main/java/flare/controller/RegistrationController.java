package flare.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import flare.model.users.Student;


@Controller
public class RegistrationController {

	@Autowired
	@Qualifier("student")
	Student student;
	/**
	 * 
	 * @return maps /registration url to registration page
	 */
	@RequestMapping("/registration")
	public String registration() {
		
		return "/registrationPage";
	}
	
	@RequestMapping("regAuth")
	public ModelAndView registrationVerification(@RequestParam("username") String uname,
			@RequestParam("password") String pword,
			@RequestParam("firstname") String fname,
			@RequestParam("lastname") String lname,
			@RequestParam("year") String yr,
			@RequestParam("semester") String sem) {
		
		
		
		ModelAndView model = new ModelAndView("/registrationVerification");
		model.addObject("msg", uname+pword+fname+lname+yr+sem);
		
		return model;
	}
	
	
}
