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
import flare.model.assignments.AssignmentsDataAccess;
import flare.model.courses.Course;
import flare.model.courses.CoursesDataAccess;

@Controller
public class TimerController {

	List<Course> courseList;
	List<Assignment> assignmentList;
	int userID;
	
	
	
	@RequestMapping("/timer")
	public String showpage (Model model) {
		System.out.println("--- TimerController.showpage() called ---");
		model.addAttribute("userID", userID);
		courseList = CoursesDataAccess.GetCourseList(4);	
		
		if(courseList == null){
			System.out.println("You got nothing....");
		}
		
		model.addAttribute("courseList", courseList);
		
		model.addAttribute("assignmentList", assignmentList);

		System.out.println("*-- Returning Timer.jsp --*");
		return "Timer";
	}
	
	@RequestMapping("/assignment")
	public String switchAssignment (HttpServletRequest request, Model model) {
		System.out.println("--- TimerController.switchAssignment() called ---");
		int courseID = (int) request.getAttribute("courseID");
		
		model.addAttribute("courseList", courseList);
		assignmentList = AssignmentsDataAccess.GetAssignmentListFromCourse(3);

		System.out.println("*-- Returning switchAssignment.jsp --*");
		return "switchAssignment";
	}
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public ModelAndView getdata() {
		System.out.println("--- TimerController.getdata() called ---");
		List<String> list = getList();

	
		ModelAndView model = new ModelAndView("index");
		
		model.addObject("lists", list);

		return model;

	}
	
	private Model SetModel(Model model){
		System.out.println("--- SetModel() called ---");
		
		
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