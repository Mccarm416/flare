package flare.model.users;

import java.time.LocalDateTime;
import java.time.Year;

import flare.model.users.dao.StudentDAO;
import flare.model.users.dao.UserDAO;

/**
 * This class provides an abstract template to the concrete model layer objects used in the user system.
 * It's fields and methods are a set of common fields and methods to all users on the system.
 * For more specialized function, classes which extend this class have been given their own
 * unique function. This class is meant to have a 1:1 relation with the user table in flaredb,
 * our MySQL database.
 * 
 * @author Sean Dougan
 * @version 3.0
 * @since 1.0
 */

public abstract class User {
	
	// fields
	// ##########################################################################################
	protected int user_id; // references the mysql primary key
	protected String userName; // the users display name
	protected String pword; // the users password stored in plain-text
	protected String email; // the users george brown email address
	protected String first_name; // the users first name
	protected String last_name; // the users last name
	protected LocalDateTime lastlogin; // time and date of users last login
	protected String display_picture; // reference to address in web server filesystem of image
	protected int account_status; // varaible stating authorized use of dealing with TOS
	protected Year current_year; // i might be changing this field around it doesnt make any sense
	protected int semester; // the current semester the user is in
	protected int role_id; // the integer reference to the table_role table
	protected String role_title; // the string representation of the users role and system access
	// data access class field
	protected UserDAO dao; // reference to users DAO, will appropriate which with injection in specialized classes
	
	// methods
	// ##########################################################################################
	// USER_ID
	
	
	protected int getUser_id() {
		return user_id;
	}
	
	//Used for creating a student for testing messaging system
	public User(int user_id, String userName, String first_name, String last_name) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	protected void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	// USERNAME
	protected String getUserName() {
		return userName;
	}
	
	protected void setUserName(String userName) {
		this.userName = userName;
	}
	
	// PASSWORD
	protected String getPword() {
		return pword;
	}
	
	protected void setPword(String pword) {
		this.pword = pword;
	}
	
	// EMAIL
	protected String getEmail() {
		return email;
	}
	
	protected void setEmail(String email) {
		this.email = email;
	}
	
	// FIRST NAME
	protected String getFirst_name() {
		return first_name;
	}
	
	protected void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	// LAST NAME
	protected String getLast_name() {
		return last_name;
	}
	
	protected void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	// LAST LOGIN
	protected LocalDateTime getLastlogin() {
		return lastlogin;
	}
	
	protected void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	// DISPLAY PICTURE
	protected String getDisplay_picture() {
		return display_picture;
	}
	
	protected void setDisplay_picture(String display_picture) {
		this.display_picture = display_picture;
	}
	
	// ACCOUNT RESTRICTION LEVEL
	protected int getAccount_status() {
		return account_status;
	}
	
	protected void setAccount_status(int account_status) {
		this.account_status = account_status;
	}
	
	// CURRENT YEAR
	protected Year getCurrent_year() {
		return current_year;
	}
	
	protected void setCurrent_year(Year current_year) {
		this.current_year = current_year;
	}
	
	// CURRENT SEMESTER
	protected int getSemester() {
		return semester;
	}
	
	protected void setSemester(int semester) {
		this.semester = semester;
	}
	
	// USERS ACCESS ROLE REFERENCE
	protected int getRole_id() {
		return role_id;
	}
	
	protected void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	// USER ROLE TITLE
	
	protected String getRole_title() {
		return role_title;
	}

	protected void setRole_title(String role_title) {
		this.role_title = role_title;
	}
	
}