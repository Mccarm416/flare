package flare.messaging;

import java.util.ArrayList;

import flare.model.users.Student;

public class ChatUtility {
	
	public static String[] getOtherUsersArray(ArrayList<Chat> activeChats, int currentUser) {
		//When given an ArrayList of Chat objects and a userId, this method returns the usernames of the other user in the chat 
		String[] otherUsers = new String[activeChats.size()];
		for (int i = 0; i <= activeChats.size(); i++) {
			Student user;
			if(activeChats.get(i).getUser1Id() == currentUser) {
				user = ChatMessageDAO.searchUserId(activeChats.get(i).getUser2Id());
				otherUsers[i] = user.getUsername();
			}
			else {
				user = ChatMessageDAO.searchUserId(activeChats.get(i).getUser1Id());
				otherUsers[i] = user.getUsername();
			}
		}
		
		return otherUsers;
	}
	
	public static ArrayList<Student> getOtherUsers(ArrayList<Chat> activeChats, int currentUser) {
		//When given an ArrayList of Chat objects and a userId, this method returns the usernames of the other user in the chat 
		ArrayList<Student> otherUsers = new ArrayList<Student>();
		for (int i = 0; i < activeChats.size(); i++) {
			Student otherUser;
			if(activeChats.get(i).getUser1Id() == currentUser) {
				otherUser = ChatMessageDAO.searchUserId(activeChats.get(i).getUser2Id());
				otherUsers.add(otherUser);
			}
			else {
				otherUser = ChatMessageDAO.searchUserId(activeChats.get(i).getUser2Id());
				otherUsers.add(otherUser);
			}
		}
		
		return otherUsers;
	}
	
	public static boolean createChatroom(Student user1, Student user2) {
		if (ChatMessageDAO.getChatWithUserIds(user1.getUserId(), user2.getUserId()) == null) {
			ChatMessageDAO.insertChat(user1, user2);
			return true;
		}
		return false;
	}

}
