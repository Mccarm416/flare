package flare.model.assignments;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import flare.data.FlareDB;

/* Flare: Student Web Application - Course Data Access
 * By: GBC Dream Team
 * Gregory Uchitel, Jamie Massel, Matthew McCarthy, Michael van Dyke, and Sean Dougan
 * 
 * Purpose: Data access for the assignments
 */

public class AssignmentsDataAccess {
	
	public static List<Assignment> GetAssignmentListFromCourse (int courseID) {
		//returns a list of the assignments for the course.  if there are none it will return null.
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection con = FlareDB.startConnection();
			String query = "SELECT * FROM table_assignment WHERE course_id = " + courseID;
			System.out.println("Creating statement...");
			Statement statement = con.createStatement();
			System.out.println("Running query...");
			results = statement.executeQuery(query);		
			
			if (results == null){
				return null;
			}
			while (results.next()) {
				Assignment assignment = new Assignment();
				assignment.setAssignmentName(results.getString("assignment_name"));
				assignment.setAssignmentID(results.getInt("assignment_id"));
				assignment.setCourseID(results.getInt("course_id"));
				assignment.setDueDate(results.getDate("due_date"));
				System.out.println("Creating assignment: " + assignment.getAssignmentName());
				assignmentList.add(assignment);		
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
			return null;
			
		}
		System.out.println("Returning " + assignmentList.size() + " assignments");
		return assignmentList;
	}
	
	public static List<Assignment> GetAssignmentListFromUser (int userID) {
		//DONT USE! returns a list of the assignments for the user.  if there are none it will return null.
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection con = FlareDB.startConnection();
			String query = "SELECT * FROM table_assignment WHERE user_id = " + userID;
			System.out.println("Creating statement...");
			Statement statement = con.createStatement();
			System.out.println("Running query...");
			results = statement.executeQuery(query);		
			
			if (results == null){
				return null;
			}
			while (results.next()) {
				Assignment assignment = new Assignment();
				assignment.setAssignmentName(results.getString("assignment_name"));
				assignment.setAssignmentID(results.getInt("assignment_id"));
				assignment.setCourseID(results.getInt("course_id"));
				assignment.setDueDate(results.getDate("due_date"));
				assignment.setGrade(results.getDouble("grade"));
				assignment.setGradeWeight(results.getDouble("grade_weight"));
				System.out.println("Creating assignment: " + assignment.getAssignmentName());
				assignmentList.add(assignment);		
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
			return null;
			
		}
		System.out.println("Returning " + assignmentList.size() + " assignments");
		return assignmentList;
	}
	
	
	public static void InsertAssignmentIntoDB(String assignmentName, int courseID, java.sql.Date dueDate, int userID) throws Exception{
		try{
			//Inserts a single assignment into the db
			Connection connect = null;
			connect = FlareDB.startConnection();
			System.out.println("Creating connection for insert...");
			//Set the SQL variables
			String sql = "INSERT INTO table_course (assignment_name,due_date,user_id,course_id) VALUES "+"(?,?,?,?)";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
		    preparedStatement.setString(1, assignmentName);
			preparedStatement.setDate(2, dueDate);
			preparedStatement.setInt(3, userID);
			preparedStatement.setInt(4, courseID);
			preparedStatement.executeUpdate();
			System.out.println("Course Created - " + assignmentName);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
	public static void DeleteAssignmentFromDB(int assignmentID) throws Exception{
		try{
			//deletes a single assignment from the db
			Connection connect = null;
			connect = FlareDB.startConnection();
			System.out.println("Creating connection for delection...");
			//Set the SQL variables
			String sql = "DELETE FROM table_assignment WHERE assignment_id = ?";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
		    preparedStatement.setInt(1, assignmentID);
			preparedStatement.executeUpdate();
			System.out.println("Assignment Deleted - " + assignmentID);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
}