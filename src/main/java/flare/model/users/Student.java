package flare.model.users;

public class Student extends User {
	//Used for testing messaging system
	public Student(int userId, String username, String firstName, String lastName) {
		super(userId, username, firstName, lastName);
	}
	public Student() {
		
	};
	
	@Override
	public void setUsername(String username) {
		super.username = username;
	}
	
	@Override
	public void setUserId(int userId) {
		super.userId = userId;
	}
	@Override
	public String getUsername() {
		return super.username;
	}
	
	@Override
	public int getUserId() {
		return super.userId;
	}
}