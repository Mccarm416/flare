package flare.messaging;


public class Chat {
	private int chatId;
	private int user1Id;
	private int user2Id;
	private int totalMessages;
	
	public Chat(int chatId, int user1Id, int user2Id, int totalMessages) {
		this.chatId = chatId;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.totalMessages = totalMessages;
	}

	public int getChatId() {
		return chatId;
	}

	public int getUser1() {
		return user1Id;
	}

	public int getUser2() {
		return user2Id;
	}

	public int getTotalMessages() {
		return totalMessages;
	}
	
	public int totalMessageIncrease() {
		totalMessages++;
		return totalMessages;
	}
}