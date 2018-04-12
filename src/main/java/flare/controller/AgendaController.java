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
import flare.model.users.User;

@Controller
public class AgendaController {

	int month = 0;
	int year = 0;
	int day = 0;
	int daysInMonth;
	int startDay;
	String dateString;
	String dateStringYMD;
	Calendar date = null;
	List<Course> courseList;
	List<Assignment> assignmentList;
	int userID;
	String datePressed;
	Boolean insertBox;
	
	@RequestMapping("/agenda")
	public String processForm(HttpServletRequest request, Model model) {
		User user = (User)request.getSession().getAttribute("user");
		userID = user.getUserId();
		System.out.println(userID);

		
		dateStringYMD = "";
		String buttonPressed = request.getParameter("AgendaButton");
		datePressed = request.getParameter("date");
		insertBox = false;
		String delete = request.getParameter("Delete");
		
		if (datePressed != null && !datePressed.isEmpty()) {
			setDateFromClick(datePressed);
			
		}
		else if(buttonPressed == null ||buttonPressed.equals("Cancel")){
			date = GregorianCalendar.getInstance(); //todays date
			month = date.get(Calendar.MONTH);
			year = date.get(Calendar.YEAR);
			day = date.get(Calendar.DAY_OF_MONTH); 
		}else if(buttonPressed.equals("-Next-")) {
			setDate(request);
			date.add(Calendar.MONTH, 1);	//add month
			month = date.get(Calendar.MONTH);
			year = date.get(Calendar.YEAR);
		}else if(buttonPressed.equals("-Previous-")) {
			setDate(request);
			date.add(Calendar.MONTH, -1);	//subtract month
			month = date.get(Calendar.MONTH);
			year = date.get(Calendar.YEAR);
		}else if (buttonPressed.equals("X")){
			
			int assignmentToDelete = Integer.parseInt(delete);
			System.out.println("HEREEEE");
				try {
					AssignmentsDataAccess.DeleteAssignmentFromDB(assignmentToDelete);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			date = GregorianCalendar.getInstance(); //todays date
			month = date.get(Calendar.MONTH);
			year = date.get(Calendar.YEAR);
			day = date.get(Calendar.DAY_OF_MONTH); 
		
		}else if (buttonPressed.equals("Submit")){
			//insert into database
			int courseID = Integer.parseInt(request.getParameter("courseID"));
			String assignmentName = request.getParameter("assignmentName");
			String dateYMD = request.getParameter("dateYMD");
			System.out.println(courseID + "...." + assignmentName + "...." + dateYMD);
			setDateFromClick(dateYMD); 
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateSend = null;
			try {
				dateSend = sdf1.parse(dateYMD);
			} catch (ParseException e1) {
							e1.printStackTrace();
			}
			java.sql.Date sqlDate = new java.sql.Date(dateSend.getTime());  
			try {
				AssignmentsDataAccess.InsertAssignmentIntoDB(assignmentName, courseID, sqlDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		//sets date in calendar
		month = Integer.parseInt(request.getParameter("selectedMonth")) -1;
		year = Integer.parseInt(request.getParameter("selectedYear"));
		day = Integer.parseInt(request.getParameter("selectedDay"));
		date = new GregorianCalendar(year, month, day);		
		return date;
	}
	public Calendar setDateFromClick(String dateString) {
		//when clicking on the calandar it takes the string from date clicked and creates a calendar
		year = Integer.parseInt(dateString.substring(0, 4));
		month = Integer.parseInt(dateString.substring(5, 7)) -1;
		day = Integer.parseInt(dateString.substring(dateString.length() - 2));
		date = new GregorianCalendar(year, month, day);		
		insertBox = true;
		
		return date;
	}
	
	
	private Model SetModel(Model model){
		CalendarBlueprint calendarBlueprint = new CalendarBlueprint(day,month,year,daysInMonth,startDay);
		DateString();
		System.out.println(dateString);
		model.addAttribute("dateString", dateString);
		model.addAttribute("dateStringYMD", dateStringYMD);
		model.addAttribute("userID", userID);
		model.addAttribute("calendarBlueprint", calendarBlueprint);
		model.addAttribute("insertBox", insertBox);
		courseList = CoursesDataAccess.GetCourseList(userID);	
		if(courseList != null){
			model.addAttribute("courseList", courseList);
			assignmentList = AssignmentsDataAccess.GetAssignmentListFromCourseList(courseList);
			if(assignmentList != null)
				model.addAttribute("assignmentList", assignmentList);
		}
		return model;
	}
	
	private void DateString() {
		//add zeros to beginning of months/days below 10. add together to create a string with the year. to be used in the jsp.
		String dayString;
		String monthString;
		String yearString; 
		if (month >= 10)
			monthString = Integer.toString(month);
			else
				monthString = "0" + Integer.toString(month);
		if (day >= 10)
			dayString = Integer.toString(day);
			else
				dayString = "0" + Integer.toString(day);
		yearString = Integer.toString(year);
		dateString = yearString + "-" + monthString + "-";
		if (datePressed != null && !datePressed.isEmpty()) 
			dateStringYMD = yearString + "-" + monthString + "-" + dayString;		
	}
	
	
	
}
