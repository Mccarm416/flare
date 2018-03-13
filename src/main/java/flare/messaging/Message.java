package flare.messaging;

public class Message {
	private String username;
	private int userId;
	private String message;
	
	
	public Message(String username, int userId, String message) {
		this.username = username;
		this.userId = userId;
		this.message = message;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getMessage() {
		return message;
	}
	
}
