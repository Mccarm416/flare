package flare.model.courses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import flare.dataaccess.FlareDB;





/* Flare: Student Web Application - Course Data Access
 * By: GBC Dream Team
 * Gregory Uchitel, Jamie Massel, Matthew McCarthy, Michael van Dyke, and Sean Dougan
 * 
 * Purpose: Data access for the courses
 */

public class CoursesDataAccess {
	
	//returns a list of the user's course objects.  if they have not been created by the user yet it will return null.
	public static List<Course> GetCourseList (int userID) {
		System.out.println("-- insertMessage() called --");
		List<Course> courseList = new ArrayList<Course>();
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = "SELECT * FROM table_course WHERE user_id = " + userID;
			System.out.println("[Executing Query]:" + sql);
		    courseList = jdbc.query(sql, new ResultSetExtractor<List<Course>>(){
		        public List<Course> extractData(ResultSet results) throws SQLException, DataAccessException {
		            List<Course> dataList = new ArrayList<Course>();
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
				dataList.add(course);		
	            	}
		        return dataList;
		        }
		    });
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
			return null;
		}
		System.out.println("Returning " + courseList.size() + " courses");
		return courseList;
	}
	
	//Inserts a single course into the db
	public static void InsertCourseIntoDB(String courseNameAdd, String courseCodeAdd, int userID) throws Exception{
		System.out.println("-- insertNote() called --");
		try{
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = String.format("INSERT INTO table_course (course_name,course_code,user_id) VALUES "+"(%1$s, %2$s, %3$s)",
		    courseNameAdd, courseCodeAdd, userID);
			System.out.println("[Executing Query]:" + sql);
			jdbc.update(sql);
			System.out.println("Course inserted into database - " + courseNameAdd);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
	
	//deletes a single course from the db
	public static void DeleteCourseFromDB(int courseID) throws Exception{
		System.out.println("-- DeleteCourseFromDB() called --");
		JdbcTemplate jdbc = FlareDB.getJdbc();
		try{
			String sql = String.format("DELETE FROM table_course WHERE course_id = %1$s", courseID);
			jdbc.update(sql);
			System.out.println("Course Deleted - " + courseID);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}

	}
}