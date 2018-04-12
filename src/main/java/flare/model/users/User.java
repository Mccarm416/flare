package flare.model.users;


import java.util.Date;

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
	protected int userid;// the users unique id number
	protected String userName; // the users display name
	protected String password; // the users password stored in plain-text
	protected String email; // the users george brown email address
	protected String firstname; // the users first name
	protected String lastname; // the users last name
	protected String accountcreation; // time and date of users last login
	protected String displaypicture; // reference to address in web server filesystem of image
	protected int enabled; // varaible stating authorized use of dealing with TOS
	protected int currentyear; // i might be changing this field around it doesnt make any sense
	protected int semester; // the current semester the user is in
	protected String authority; // the string representation of the users role and system access
	
	
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
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// EMAIL
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// FIRST NAME
	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	// LAST NAME
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	// ACCOUNT CREATION
	public String getAccountCreation() {
		return accountcreation;
	}
	
	public void setAccountCreation(String accountcreation) {
		this.accountcreation = accountcreation;
	}
	
	// DISPLAY PICTURE
	public String getDisplayPicture() {
		return displaypicture;
	}
	
	public void setDisplayPicture(String displaypicture) {
		this.displaypicture = displaypicture;
	}
	
	// ENABLED
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	// CURRENT YEAR
	public int getCurrentYear() {
		return currentyear;
	}
	
	public void setCurrentYear(int currentyear) {
		this.currentyear = currentyear;
	}
	
	// CURRENT SEMESTER
	public int getSemester() {
		return semester;
	}
	
	public void setSemester( int semester) {
		this.semester = semester;
	}

	// USER ROLE TITLE
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	// USER ID NUMBER
	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}
	



}
