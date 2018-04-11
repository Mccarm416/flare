package flare.model.assignments;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import flare.dataaccess.FlareDB;

/* Flare: Student Web Application - Course Data Access
 * By: GBC Dream Team
 * Gregory Uchitel, Jamie Massel, Matthew McCarthy, Michael van Dyke, and Sean Dougan
 * 
 * Purpose: Data access for the assignments
 */

public class AssignmentsDataAccess {

	//returns a list of the assignments for the course.  if there are none it will return null.
	public static List<Assignment> GetAssignmentListFromCourse (int courseID) {
		System.out.println("-- GetAssignmentListFromCourse() called --");
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = "SELECT * FROM table_assignment WHERE course_id = " + courseID;
			System.out.println("[Executing Query]:" + sql);
		    assignmentList = jdbc.query(sql, new ResultSetExtractor<List<Assignment>>(){
		        public List<Assignment> extractData(ResultSet results) throws SQLException, DataAccessException {
		            List<Assignment> dataList = new ArrayList<Assignment>();
		            while (results.next()) {
						Assignment assignment = new Assignment();
						assignment.setAssignmentName(results.getString("assignment_name"));
						assignment.setAssignmentID(results.getInt("assignment_id"));
						assignment.setCourseID(results.getInt("course_id"));
						assignment.setDueDate(results.getDate("due_date"));
						System.out.println("Creating assignment: " + assignment.getAssignmentName());
						dataList.add(assignment);		
					}
		            return dataList;
		        } 
		    });
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
			return null;
			
		}
		System.out.println("Returning " + assignmentList.size() + " assignments");
		return assignmentList;
	}
	
	//DONT USE! returns a list of the assignments for the user.  if there are none it will return null.
	public static List<Assignment> GetAssignmentListFromUser (int userID) {
		System.out.println("-- GetAssignmentListFromUser() called --");
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = "SELECT * FROM table_assignment WHERE user_id = " + userID;
			System.out.println("[Executing Query]:" + sql);
		    assignmentList = jdbc.query(sql, new ResultSetExtractor<List<Assignment>>(){
		        public List<Assignment> extractData(ResultSet results) throws SQLException, DataAccessException {
		            List<Assignment> dataList = new ArrayList<Assignment>();
		            while (results.next()) {
						Assignment assignment = new Assignment();
						assignment.setAssignmentName(results.getString("assignment_name"));
						assignment.setAssignmentID(results.getInt("assignment_id"));
						assignment.setCourseID(results.getInt("course_id"));
						assignment.setDueDate(results.getDate("due_date"));
						assignment.setGrade(results.getDouble("grade"));
						assignment.setGradeWeight(results.getDouble("grade_weight"));
						System.out.println("Creating assignment: " + assignment.getAssignmentName());
		            }
		            return dataList;
	        	}
		    });
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
			return null;
			
		}
		
		System.out.println("Returning " + assignmentList.size() + " assignments");
		return assignmentList;
	}
	
	//Inserts a single assignment into the db
	public static void InsertAssignmentIntoDB(String assignmentName, int courseID, Date dueDate, int userID) throws Exception{
		System.out.println("-- InsertAssignmentIntoDB() called --");
		
		try{
			JdbcTemplate jdbc = FlareDB.getJdbc();
			//Set the SQL variables
			String sql = String.format("INSERT INTO table_course (assignment_name,due_date,user_id,course_id) VALUES "+"(%1$s, %2$s, %3$s, %4$s)",
					assignmentName, dueDate, userID, courseID);
			System.out.println("[Executing Query]:" + sql);
			jdbc.update(sql);
			System.out.println("Course Created - " + assignmentName);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
	
	//deletes a single assignment from the db
	public static void DeleteAssignmentFromDB(int assignmentID) throws Exception{
		System.out.println("-- DeleteAssignmentFromDB() called --");

		try{
			JdbcTemplate jdbc = FlareDB.getJdbc();

			String sql = String.format("DELETE FROM table_assignment WHERE assignment_id = ?", assignmentID);
			System.out.println("[Executing Query]:" + sql);
			jdbc.execute(sql);
			System.out.println("Assignment Deleted - " + assignmentID);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
}