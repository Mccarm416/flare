package flare.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import flare.factory.StudentFactory;
import flare.model.users.Student;

public class DBUtility {
	
	//Used to search the db for a user using their userId. Returns null if no user was found.
	public static Student getStudent(int userId) {
			System.out.println("--- DBUtility.getStudent() called ---");
			Student user = null;
			try {
				System.out.println("Creating connection...");
				JdbcTemplate jdbc = FlareDB.getJdbc();
				String sql = "SELECT * FROM `users` WHERE userid = " + userId;				
				System.out.println("[Executing SQL]:" + sql);
				user = jdbc.query(sql, new ResultSetExtractor<Student>(){
				public Student extractData(ResultSet results) throws SQLException, DataAccessException {
					Student student = null;
					while(results.next()) {	
						if (results.getInt("userid") == userId) {
								StudentFactory sf = new StudentFactory();
				            	try {
									student = sf.getObject();
					            	student.DB().bindObjectToDB(results.getString("username"));
								} catch (Exception e) {
									e.printStackTrace();
								}
						}
		            }
					return student;
					}
				});
			} catch (Exception e) {
				System.out.println("*** Error! ***");
				e.printStackTrace();
			}
			return user;
		
	}

}
