package flare.messaging;

import java.util.ArrayList;

public class Chat {
	private int chatId;
	private ArrayList<Message> messages = new ArrayList<Message>();
	private int user1;
	private int user2;
	private static int nextChatId = 0;
	
	public Chat(ArrayList<Message> messages, int user1, int user2) {
		this.messages = messages;
		this.user1 = user1;
		this.user2 = user2;
		chatId = nextChatId;
		nextChatId++;
	}
}
