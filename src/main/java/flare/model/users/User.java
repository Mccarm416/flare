package flare.model.users;

import java.time.LocalDateTime;
import java.time.Year;


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
	protected String role_title; // the string representation of the users role and system access
	
	
	// methods
	// ##########################################################################################
	// USERNAME
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	// PASSWORD
	public String getPword() {
		return pword;
	}
	
	public void setPword(String pword) {
		this.pword = pword;
	}
	
	// EMAIL
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// FIRST NAME
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	// LAST NAME
	public String getLast_name() {
		return last_name;
	}
	
	protected void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	// LAST LOGIN
	public LocalDateTime getLastlogin() {
		return lastlogin;
	}
	
	public void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	// DISPLAY PICTURE
	public String getDisplay_picture() {
		return display_picture;
	}
	
	public void setDisplay_picture(String display_picture) {
		this.display_picture = display_picture;
	}
	
	// ACCOUNT RESTRICTION LEVEL
	public int getAccount_status() {
		return account_status;
	}
	
	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}
	
	// CURRENT YEAR
	public Year getCurrent_year() {
		return current_year;
	}
	
	public void setCurrent_year(Year current_year) {
		this.current_year = current_year;
	}
	
	// CURRENT SEMESTER
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	// USER ROLE TITLE
	public String getRole_title() {
		return role_title;
	}

	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}

}
