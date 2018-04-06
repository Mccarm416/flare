package flare.model.timer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import flare.data.FlareDB;
import flare.model.assignments.Assignment;

import flare.data.FlareDB;


public class TimerDAO {

	
	public static List<TimerCO> GetTimerCourseList (int Course_ID) {
		List<TimerCO> courseList = new ArrayList<TimerCO>();
		Connection connection = FlareDB.startConnection();
		connection = FlareDB.startConnection();
		//Set the SQL variables
		
		
		String query = "SELECT * FROM table_study_session_assignment  WHERE course_id = " + Course_ID;
		
	
		
		//TimerCO timerCO = new TimerCO(study_session_id,session_length,time,course_id,date);
		return courseList;
	}
	
	public static List<TimerAS> GetTimerAssignmentList (int Assignment_ID) {
		List<TimerAS> assignmentList = new ArrayList<TimerAS>();
		Connection connection = FlareDB.startConnection();
		String query = "SELECT * table_study_session  WHERE course_id = " + Assignment_ID;
		
		
		return assignmentList;
	}
	
}
