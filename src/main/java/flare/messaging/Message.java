package flare.messaging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String username;
	private int userId;
	private String message;
	private String messageTime;
	
	
	public Message(String username, int userId, String message) {
		this.username = username;
		this.userId = userId;
		this.message = message;
		messageTime = longToDate(new Date().getTime());
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
	
	
	public String getMessageTime() {
		return messageTime;
	}

	private String longToDate(long date) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = formatDate.format(date);
		return formattedDate;
	}
	
}
