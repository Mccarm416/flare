package flare.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import flare.model.users.Student;

public class DBUtility {
	
	//Used to search the db for a user using their userId. Returns null if no user was found.
	public static Student getStudent(int userId) {
			System.out.println("-- getStudent() called --");
			Student user = null;
			try {
				System.out.println("Creating connection...");
				JdbcTemplate jdbc = FlareDB.getJdbc();
				String sql = "SELECT * FROM `users` WHERE userid = " + userId;
				System.out.println("Running query...");
				
				
				user = jdbc.query(sql, new ResultSetExtractor<Student>(){
				public Student extractData(ResultSet results) throws SQLException, DataAccessException {
		            	if (results.getInt("userid") == userId)
			            while(results.next()) {
			            	Student student = new Student();
			            	student.DB().bindObjectToDB(results.getString("username"));
							return student;
			            }
			            return null;
	    			}
				});
			} catch (Exception e) {
				System.out.println("Error!");
				System.out.println(e);
				
			}
			return user;
		
	}

}
