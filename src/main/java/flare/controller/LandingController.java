package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {

	@RequestMapping("/TTTT	")
	public String index() {
		
		return "index";
	}
}
