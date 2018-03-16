package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {

	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("#Registration")
	public String RDLandToReg() {
		
		return "registration";
	}
	
	@RequestMapping("#Login")
	public String RDLandToLog() {
		
		return "login";
	}
}
