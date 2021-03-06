package flare.messaging;


public class Chat {
	private int chatId;
	private int user1Id;
	private int user2Id;
	private int totalMessages;
	
	
	public Chat() {
	}


	public Chat(int chatId, int user1Id, int user2Id, int totalMessages) {
		this.chatId = chatId;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.totalMessages = totalMessages;
	}

	
	public int getChatId() {
		return chatId;
	}


	public void setChatId(int chatId) {
		this.chatId = chatId;
	}


	public int getUser1Id() {
		return user1Id;
	}


	public void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}


	public int getUser2Id() {
		return user2Id;
	}


	public void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
	}


	public int getTotalMessages() {
		return totalMessages;
	}


	public void setTotalMessages(int totalMessages) {
		this.totalMessages = totalMessages;
	}


	public int totalMessageIncrease() {
		totalMessages++;
		return totalMessages;
	}
}
