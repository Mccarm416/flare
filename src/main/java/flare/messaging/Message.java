package flare.messaging;

import java.util.Date;

public class Message {
	private String username;
	private int userId;
	private String message;
	private long timeStamp;
	
	
	public Message(String username, int userId, String message) {
		this.username = username;
		this.userId = userId;
		this.message = message;
		timeStamp = new Date().getTime();
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
