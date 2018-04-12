package flare.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import flare.factory.StudentFactory;
import flare.model.assignments.Assignment;
import flare.model.assignments.AssignmentsDataAccess;
import flare.model.courses.Course;
import flare.model.courses.CoursesDataAccess;
import flare.model.notes.Note;
import flare.model.notes.NotesDAO;
import flare.model.users.Student;
import flare.model.timer.ATimer;

@Controller
public class TimerController {

	

	int userID;
	
	
	//timer
	@RequestMapping("/")
	public String showpage (Model model) {
		System.out.println("--- TimerController.showpage() called ---");
		//Create dummy student
				StudentFactory sf = new StudentFactory();
				Student currentUser = null;
				try {
					currentUser = sf.getObject();
					currentUser.DB().bindObjectToDB("bourgeois.goblin");
					//Add the users information the model
				
		
					List<Course> courseList = CoursesDataAccess.GetCourseList(currentUser.getUserId());
					model.addAttribute("courseList", courseList);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
		
	

		System.out.println("*-- Returning Timer.jsp --*");
		return "Timer";
	}
	
	@RequestMapping("course")
	public String saveCourse( @RequestParam("courseList") int CourseList, HttpServletRequest request, Model model) {
		
		
		//Create dummy student 
		StudentFactory sf = new StudentFactory();
		Student currentUser = null;
		try {
			currentUser = sf.getObject();
			currentUser.DB().bindObjectToDB("bourgeois.goblin");
			//Add the users information the model
		

			List<Course> courseList = CoursesDataAccess.GetCourseList(currentUser.getUserId());
			model.addAttribute("courseList", courseList);
			List<Assignment> assignmentList = AssignmentsDataAccess.GetAssignmentListFromCourse(CourseList);
			model.addAttribute("assignmentList", assignmentList);
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return "Timer";	
	}
	
	@RequestMapping("/insertTime")
	public String insertTime () {
		
		
		return "Timer";
	}
	
	@RequestMapping("etime")
	public String saveTime ( @RequestParam("courseSelect") HttpServletRequest request, Model model) {
		System.out.println("--- TimerController.switchAssignment() called ---");
		int courseID = (int) request.getAttribute("courseID");
		int assignmentID = (int) request.getAttribute("assignmentID");
		
		//model.addAttribute("courseList", courseList);
		//	assignmentList = AssignmentsDataAccess.GetAssignmentListFromCourse()
		
		//hours: hrs, minutes:mins, seconds: secs,
		
		
		
		 int session_length = (int) request.getAttribute("convTime");
		
		 Time time =  (Time)request.getAttribute("Time");
		
		 Date date = (Date)request.getAttribute("currDate");
		 
		
		
		// --- GET USER FROM SESSION ID ---
		//Create dummy student
		StudentFactory sf = new StudentFactory();
		Student currentUser = null;
		try {
			currentUser = sf.getObject();
			currentUser.DB().bindObjectToDB("bourgeois.goblin");
			int user_id = currentUser.getUserId();
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		//model.addAttribute("courseList", courseList);
	//	assignmentList = AssignmentsDataAccess.GetAssignmentListFromCourse(3);

		System.out.println("*-- Returning time.jsp --*");
		return "Timer";
	}
	
	@RequestMapping(value = "/recTimes", method = RequestMethod.GET)
	public ModelAndView getdata() {
		System.out.println("--- recTimes.getdata() called ---");
		//List<String> list = getList();

	
		ModelAndView model = new ModelAndView("index");
		
		//model.addObject("lists", list);

		return model;

	}
	
	
	
	
	
	@RequestMapping(value = "/timer", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	int Submit(@RequestParam("setSecs") int setSecs, @RequestParam("education") int education) {
	   int resp = 0;
	   System.out.println(setSecs);
	   System.out.println(education);
	    return setSecs;
	}
	
	
	
	
	
}