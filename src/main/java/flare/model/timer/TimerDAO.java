`package flare.model.timer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import flare.data.FlareDB;
import flare.messaging.ChatMessage;
import flare.model.assignments.Assignment;

import flare.data.FlareDB;


public class TimerDAO {

	// Creates a list for times on courses
	public static List<ATimer> GetATimerList (int Course_ID) {
		List<ATimer> aTimerList = new ArrayList<ATimer>();
		Connection connection = FlareDB.startConnection();
		connection = FlareDB.startConnection();
	
		ResultSet results;
	
		try {
			System.out.println("Running query...");
			
			Statement statement = connection.createStatement();
		String query = "SELECT * FROM table_study_session_assignment  WHERE course_id = " + Course_ID;
		results = statement.executeQuery(query);
		
		if (results != null) {
			
			while (results.next()) {
				ATimer aTimer = new ATimer();
				aTimer.setUser_id(results.getInt("user_id"));
				aTimer.setCourse_id(results.getInt("course_id"));
				aTimer.setStudy_session_id(results.getInt("session_id"));
				aTimer.setSession_length(results.getInt("session_length"));	
				aTimer.setDate(results.getDate("date"));
				aTimer.setTime(results.getTime("time"));
				aTimerList.add(aTimer);
			}
		}}catch(Exception e) {
		
			System.out.println("aTimer failed!! \n");
			System.out.println(e);
			return null;
		}
	
		
		return aTimerList;
	}
	
	
	
	// Creates a list for Times on Assignments
	public static List<TimerAS> GetTimerList (int assignment_ID) {
				List<TimerAS> timerList = new ArrayList<TimerAS>();
		try {
			ResultSet results;

		Connection connection = FlareDB.startConnection();
		String query = "SELECT * table_study_session_assignment  WHERE assignment_id = " + assignment_ID;
		
		System.out.println("Running query...");
		
		Statement statement = connection.createStatement();
		results = statement.executeQuery(query);
		
		if (results != null) {
			
			while (results.next()) {
				TimerAS timerAS = new TimerAS();
				timerAS.setUser_id(results.getInt("user_id"));
				timerAS.setCourse_id(results.getInt("course_id"));
				timerAS.setStudy_session_id(results.getInt("session_id"));
				timerAS.setSession_length(results.getInt("session_length"));
				timerAS.setAssignment_id(results.getInt("assignment_id"));
				timerAS.setDate(results.getDate("date"));
				timerAS.setTime(results.getTime("time"));
				timerList.add(timerAS);
			}
		}}catch(Exception e) {
		
			System.out.println("TimerAS failed!! \n");
			System.out.println(e);
			return null;
		}
		
		return timerList;
	}
	}
	
	
	
	
