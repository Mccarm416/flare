package flare.model.users.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;

import flare.data.FlareDB;
import flare.model.users.Student;


public class StudentDAO extends UserDAO {
	
	//TODO private list variable to hold result set using RowMapper API
		// fields
		// #####################################################################################
	
		// methods
		// ######################################################################################
		/*
		 *  Using constructor injection, the data source defined in flare-config.xml is passed in
		 *  during initialization of the object and assigned to the jdbc template. There is only
		 *  one single data source in the configuration, so simple autowiring will be the most
		 *  efficient. This is a PRIVATE CONSTRUCTOR.
		 */
	public StudentDAO(DataSource dataSource) {
		
		super(dataSource);
	}

	//TODO CRUD methods
	
	
	public static Student searchUserId(int userId) {
		Student user = null;
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_user WHERE user_id = " + userId;
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					user = new Student();
					user.setUserId(results.getInt("user_id"));
					user.setUsername(results.getString("userName"));
				}
			}
			else {
				return user;
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		
		System.out.println("Returning user - " + user.getUserId() + ":" + user.getUsername());
		return user;
	}
	
	public static Student searchUsername(String username) {
		Student user = null;
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_user WHERE userName = '" + username + "'";
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					user = new Student();
					user.setUserId(results.getInt("user_id"));
					user.setUsername(results.getString("userName"));
				}
			}
			else {
				return user;
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		return user;
	}
}