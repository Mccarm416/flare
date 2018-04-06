package flare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import flare.model.assignments.Assignment;
import flare.model.courses.Course;
import flare.model.courses.CoursesDataAccess;

@Controller
public class TimerController {

	List<Course> courseList;
	List<Assignment> assignmentList;
	int userID;
	
	@RequestMapping("/")
	public String showpage (Model model) {
		
		model.addAttribute("userID", userID);
		courseList = CoursesDataAccess.GetCourseList(userID);	
		
		model.addAttribute("courseList", courseList);
		model.addAttribute("assignmentList", assignmentList);

		return "Timer";
	}
	
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<String> list = getList();

	
		ModelAndView model = new ModelAndView("index");
		
		model.addObject("lists", list);

		return model;

	}
	
	private Model SetModel(Model model){
		
		
		
		return model;
	}
	
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