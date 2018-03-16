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
	protected int userId; // references the mysql primary key
	protected String username; // the users display name
	protected String pword; // the users password stored in plain-text
	protected String email; // the users george brown email address
	protected String firstName; // the users first name
	protected String lastName; // the users last name
	protected LocalDateTime lastLogin; // time and date of users last login
	protected String displayPicture; // reference to address in web server filesystem of image
	protected int accountStatus; // varaible stating authorized use of dealing with TOS
	protected Year currentYear; // i might be changing this field around it doesnt make any sense
	protected int semester; // the current semester the user is in
	protected int roleId; // the integer reference to the table_role table
	protected String roleTitle; // the string representation of the users role and system access
	// data access class field
	protected UserDAO dao; // reference to users DAO, will appropriate which with injection in specialized classes
	
	// methods
	// ##########################################################################################
	// USER_ID
	
	
	protected int getUserId() {
		return userId;
	}
	
	//Used for creating a student for testing messaging system
	public User(int userId, String userName, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.username = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	protected void setUserId(int userId) {
		this.userId = userId;
	}
	
	// USERNAME
	protected String getUsername() {
		return username;
	}
	
	protected void setUsername(String username) {
		this.username = username;
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
	protected String getFirstName() {
		return firstName;
	}
	
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// LAST NAME
	protected String getLastName() {
		return lastName;
	}
	
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// LAST LOGIN
	protected LocalDateTime getLastLogin() {
		return lastLogin;
	}
	
	protected void setLastlogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	// DISPLAY PICTURE
	protected String getDisplay_picture() {
		return displayPicture;
	}
	
	protected void setDisplay_picture(String display_picture) {
		this.displayPicture = display_picture;
	}
	
	// ACCOUNT RESTRICTION LEVEL
	protected int getAccountStatus() {
		return accountStatus;
	}
	
	protected void setAccountStatus(int account_status) {
		this.accountStatus = account_status;
	}
	
	// CURRENT YEAR
	protected Year getCurrentYear() {
		return currentYear;
	}
	
	protected void setCurrentYear(Year currentYear) {
		this.currentYear = currentYear;
	}
	
	// CURRENT SEMESTER
	protected int getSemester() {
		return semester;
	}
	
	protected void setSemester(int semester) {
		this.semester = semester;
	}
	
	// USERS ACCESS ROLE REFERENCE
	protected int getRoleId() {
		return roleId;
	}
	
	protected void setRole_id(int roleId) {
		this.roleId = roleId;
	}
	
	// USER ROLE TITLE
	
	protected String getRoleTitle() {
		return roleTitle;
	}

	protected void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	
}