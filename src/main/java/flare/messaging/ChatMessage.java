package flare.messaging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage {
	private int chatId; //ID for the chat which this message is a part of
	private int fromUserId;
	private String fromUsername;
	private int toUserId;
	private String toUsername;
	private String message;
	private String messageTime;
	
	
	public ChatMessage() {
	}


	public ChatMessage(int chatId, int fromUserId, String fromUsername, int toUserId, String toUsername, String message) {
		//Used for creating entries in the db
		this.chatId = chatId;
		this.fromUserId = fromUserId;
		this.fromUsername = fromUsername;
		this.toUserId = toUserId;
		this.toUsername = toUsername;
		this.message = message;
		messageTime = longToDate(new Date().getTime());
	}

	public ChatMessage(int chatId, int fromUserId, String fromUsername, int toUserId, String toUsername, String message,
			String messageTime) {
		//Used for pulling entries from the db
		this.chatId = chatId;
		this.fromUserId = fromUserId;
		this.fromUsername = fromUsername;
		this.toUserId = toUserId;
		this.toUsername = toUsername;
		this.message = message;
		this.messageTime = messageTime;
	}


	public int getChatId() {
		return chatId;
	}


	public void setChatId(int chatId) {
		this.chatId = chatId;
	}


	public int getFromUserId() {
		return fromUserId;
	}


	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}


	public String getFromUsername() {
		return fromUsername;
	}


	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}


	public int getToUserId() {
		return toUserId;
	}


	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}


	public String getToUsername() {
		return toUsername;
	}


	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getMessageTime() {
		return messageTime;
	}


	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}


	private String longToDate(long date) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = formatDate.format(date);
		return formattedDate;
	}
	
}
