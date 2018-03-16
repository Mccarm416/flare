package flare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showpage() {
		return "Timer";
	}
	
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<String> list = getList();

		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);

		return model;

	}
	
	// @GetMapping("/greeting")
	  //  public String greetingForm(Model model) {
	      //  model.addAttribute("greeting", new Greeting());
	      //  return "greeting";
	   // }
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}
	
}
