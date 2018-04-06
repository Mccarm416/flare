package flare.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flare.model.assignments.Assignment;
import flare.model.assignments.AssignmentsDataAccess;
import flare.model.courses.Course;
import flare.model.courses.CoursesDataAccess;

@Controller
public class CoursesController {
	
	List<Course> courseList;
	List<Assignment> assignmentList;
	int userID;
	Boolean editPressed; 
	
	@RequestMapping("/courses")
	public String processForm(HttpServletRequest request, Model model) {
		userID = 1; //--------fix once login is done!!
		String InfoSubmitted = request.getParameter("CourseButton");
		
		if (InfoSubmitted == null || InfoSubmitted.equals("Cancel")){
			editPressed = false;
			model = SetModel(model);
		}
		else if (InfoSubmitted.equals("Edit")){
			editPressed = true;
			model = SetModel(model);
		}
		else if (InfoSubmitted.equals("Save")){
			DeleteCourses(request);
			InsertCourses(request);
			editPressed = false;
			model = SetModel(model);
		}
		
		return "courses";
	}
	
	
	private void DeleteCourses(HttpServletRequest request){
		String deleteSelected[] = request.getParameterValues("delete");
		if(deleteSelected != null){
			for(int i = 0; i < deleteSelected.length; i++){
				try {
					CoursesDataAccess.DeleteCourseFromDB(Integer.parseInt(deleteSelected[i]));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void InsertCourses(HttpServletRequest request){
		for(int i = 0; i < 8; i++){
			String courseNameAdd = request.getParameter("courseNameAdd"+i);
			String courseCodeAdd = request.getParameter("courseCodeAdd"+i);
			if (courseCodeAdd != null && !courseCodeAdd.isEmpty() && courseNameAdd != null && !courseNameAdd.isEmpty()){
				try {
					CoursesDataAccess.InsertCourseIntoDB(courseNameAdd, courseCodeAdd, userID);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Model SetModel(Model model){
		model.addAttribute("userID", userID);
		courseList = CoursesDataAccess.GetCourseList(userID);	
		if(courseList != null){
			model.addAttribute("courseList", courseList);
			assignmentList = AssignmentsDataAccess.GetAssignmentListFromCourse(userID);
			if(assignmentList != null)
				model.addAttribute("assignmentList", assignmentList);
		}
		model.addAttribute("editPressed", editPressed);
		return model;
	}
}
	