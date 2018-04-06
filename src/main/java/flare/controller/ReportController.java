package flare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ReportController {

	@RequestMapping("/")
	public String showpage() {
		return "Reports";
	}
	
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public ModelAndView getdata() {

		//List<String> list = getGraphData();

	
		ModelAndView model = new ModelAndView("index");
		
	//	model.addObject("lists", list);

		return model;

	}
	
	//public String getGraphData() 
	
	
}
