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
	protected String firstname; // the users first name
	protected String lastname; // the users last name
	protected LocalDateTime lastlogin; // time and date of users last login
	protected String displaypicture; // reference to address in web server filesystem of image
	protected int accountstatus; // varaible stating authorized use of dealing with TOS
	protected Year currentyear; // i might be changing this field around it doesnt make any sense
	protected int semester; // the current semester the user is in
	protected String roletitle; // the string representation of the users role and system access
	
	
	// methods
	// ############################################################################################
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
		return firstname;
	}
	
	public void setFirst_name(String first_name) {
		this.firstname = first_name;
	}
	
	// LAST NAME
	public String getLast_name() {
		return lastname;
	}
	
	protected void setLast_name(String last_name) {
		this.lastname = last_name;
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
		return displaypicture;
	}
	
	public void setDisplay_picture(String display_picture) {
		this.displaypicture = display_picture;
	}
	
	// ACCOUNT RESTRICTION LEVEL
	public int getAccount_status() {
		return accountstatus;
	}
	
	public void setAccount_status(int account_status) {
		this.accountstatus = account_status;
	}
	
	// CURRENT YEAR
	public Year getCurrent_year() {
		return currentyear;
	}
	
	public void setCurrent_year(Year current_year) {
		this.currentyear = current_year;
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
		return roletitle;
	}

	public void setRole_title(String role_title) {
		this.roletitle = role_title;
	}	

}
