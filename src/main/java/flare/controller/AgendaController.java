package flare.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flare.model.assignments.CalendarBlueprint;
import flare.model.courses.Course;
import flare.model.courses.CoursesDataAccess;

@Controller
public class AgendaController {

	int month = 0;
	int year = 0;
	int day = 0;
	int daysInMonth;
	int startDay;
	Calendar date = null;

	List<Course> courseList;
	int userID;
	
	
	@RequestMapping("/agenda")
	public String processForm(HttpServletRequest request, Model model) {
		userID = 1;
		
		String buttonPressed = request.getParameter("AgendaButton");
		
		if(buttonPressed == null ||buttonPressed.equals("Cancel")){
			date = GregorianCalendar.getInstance(); //todays date
			month = date.get(Calendar.MONTH);
			year = date.get(Calendar.YEAR);
			day = date.get(Calendar.DAY_OF_MONTH); 
		}else if(buttonPressed.equals("-Next-")) {
			setDate(request);
			date.add(Calendar.MONTH, 1);	
			month = date.get(Calendar.MONTH);
			year = date.get(Calendar.YEAR);
		}else if(buttonPressed.equals("-Previous-")) {
			setDate(request);
			date.add(Calendar.MONTH, -1);	
			month = date.get(Calendar.MONTH);
			year = date.get(Calendar.YEAR);
		}else if (buttonPressed.equals("to do later")){
			setDate(request);
		}
		daysInMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		startDay = firstDayInMonth(month, year);
		month = month + 1;   //makes jan = 1, december = 12. once calc over
	
		model = SetModel(model);
		return "agenda";
	}
	public static int firstDayInMonth(int month, int year) {
		//returns the start date of the month for the calendar... sunday = 1, saterday = 7
	    Calendar monthStart = new GregorianCalendar(year, month, 1);
	    return monthStart.get(Calendar.DAY_OF_WEEK);
	}
	
	public Calendar setDate(HttpServletRequest request) {
		month = Integer.parseInt(request.getParameter("selectedMonth")) -1;
		year = Integer.parseInt(request.getParameter("selectedYear"));
		day = Integer.parseInt(request.getParameter("selectedDay"));
		date = new GregorianCalendar(year, month, day);		
		return date;
	}
	private Model SetModel(Model model){
		CalendarBlueprint calendarBlueprint = new CalendarBlueprint(day,month,year,daysInMonth,startDay);
		model.addAttribute("userID", userID);
		model.addAttribute("calendarBlueprint", calendarBlueprint);
		courseList = CoursesDataAccess.GetCourseList(userID);	
		if(courseList != null){
			model.addAttribute("courseList", courseList);;
		}
		return model;
	}
	
}