package flare.model.courses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import flare.data.FlareDB;



/* Flare: Student Web Application - Course Data Access
 * By: GBC Dream Team
 * Gregory Uchitel, Jamie Massel, Matthew McCarthy, Michael van Dyke, and Sean Dougan
 * 
 * Purpose: Data access for the courses
 */

public class CoursesDataAccess {
	
	public static List<Course> GetCourseList (int userID) {
		//returns a list of the user's course objects.  if they have not been created by the user yet it will return null.
		List<Course> courseList = new ArrayList<Course>();
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection con = FlareDB.startConnection();
			String query = "SELECT * FROM table_course WHERE user_id = " + userID;
			System.out.println("Creating statement...");
			Statement statement = con.createStatement();
			System.out.println("Running query...");
			results = statement.executeQuery(query);		
			
			if (results == null){
				return null;
			}
			while (results.next()) {
				Course course = new Course();
				course.setCourseName(results.getString("course_name"));
				course.setCourseCode(results.getString("course_code"));
				course.setCourseID(results.getInt("course_id"));
				course.setGrade(results.getDouble("grade"));
				course.setProfessorName1(results.getString("professor1_name"));
		        course.setProfessorName2(results.getString("professor2_name"));
				course.setProfessorEmail1(results.getString("professor1_email"));
				course.setProfessorEmail1(results.getString("professor2_email"));
				System.out.println("Creating course: " + course.getCourseID());
				courseList.add(course);		
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
			return null;
		}
		System.out.println("Returning " + courseList.size() + " courses");
		return courseList;
	}
	public static void InsertCourseIntoDB(String courseNameAdd, String courseCodeAdd, int userID) throws Exception{
		try{
			//Inserts a single course into the db
			Connection connect = null;
			connect = FlareDB.startConnection();
			System.out.println("Creating connection for insert...");
			//Set the SQL variables
			String sql = "INSERT INTO table_course (course_name,course_code,user_id) VALUES "+"(?,?,?)";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
		    preparedStatement.setString(1, courseNameAdd);
			preparedStatement.setString(2, courseCodeAdd);
			preparedStatement.setInt(3, userID);
			preparedStatement.executeUpdate();
			System.out.println("Course Created - " + courseNameAdd);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
	public static void DeleteCourseFromDB(int courseID) throws Exception{
		try{
			//deletes a single course from the db
			Connection connect = null;
			connect = FlareDB.startConnection();
			System.out.println("Creating connection for delection...");
			//Set the SQL variables
			String sql = "DELETE FROM table_course WHERE course_id = ?";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
		    preparedStatement.setInt(1, courseID);
			preparedStatement.executeUpdate();
			System.out.println("Course Deleted - " + courseID);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
}