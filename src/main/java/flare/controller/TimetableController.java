package flare.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.experimental.theories.internal.Assignments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flare.model.assignments.Assignment;
import flare.model.assignments.AssignmentsDataAccess;
import flare.model.assignments.CalendarBlueprint;
import flare.model.courses.Course;
import flare.model.courses.CoursesDataAccess;
import flare.model.timetable.Timetable;
import flare.model.timetable.TimetableDataAccess;
import flare.model.users.User;

@Controller
public class TimetableController {

	List<Course> courseList;
	List<Timetable> timetableList;
	int userID;
	String time;
	String day;
	
	@RequestMapping("/timetable")
	public String processForm(HttpServletRequest request, Model model) throws Exception {

		User user = (User)request.getSession().getAttribute("user");
		userID = user.getUserId();
		
		time = request.getParameter("time");
		day = request.getParameter("day");
		System.out.println("test1");
		String buttonPressed = request.getParameter("TimetableButton");
		System.out.println("test2");
		String delete = request.getParameter("Delete");
		
		if(buttonPressed == null ||buttonPressed.equals("Cancel")){
		
		}else if(buttonPressed.equals("Submit")) {
			int courseID = Integer.parseInt(request.getParameter("courseID"));
			int timeStart = Integer.parseInt(request.getParameter("timeStart"));
			int timeEnd = Integer.parseInt(request.getParameter("timeEnd"));
			int labLecture = Integer.parseInt(request.getParameter("labLecture"));
			int timeDay = Integer.parseInt(request.getParameter("dayOfWeek"));
			String room  = request.getParameter("room");
			TimetableDataAccess.InsertTimetableIntoDB(courseID, timeStart, timeEnd, room, labLecture, timeDay);
			
		}else if (buttonPressed.equals("X")){
			
			int timetableToDelete = Integer.parseInt(delete);
					try {
					TimetableDataAccess.DeleteTimetableFromDB(timetableToDelete);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
		}
		
		
		
		
		model = SetModel(model);
		return "timetable";
	}
	
	
	private Model SetModel(Model model){
	
		model.addAttribute("userID", userID);
		model.addAttribute("time", time);
		model.addAttribute("day", day);
		courseList = CoursesDataAccess.GetCourseList(userID);	
		if(courseList != null){
			model.addAttribute("courseList", courseList);
			timetableList = TimetableDataAccess.GetTimetableListFromCourseList(courseList);
			if(timetableList != null)
				model.addAttribute("timetableList", timetableList);
		}
		return model;
	}
		
}


