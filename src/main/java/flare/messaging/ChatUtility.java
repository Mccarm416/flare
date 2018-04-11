package flare.messaging;

import java.util.ArrayList;
import java.util.List;

import flare.dataaccess.DBUtility;
import flare.model.users.Student;

public class ChatUtility {

	//When given an ArrayList of Chat objects and a userId, this method returns the usernames of the other user in the chat 
	public static String[] getOtherUsersArray(ArrayList<Chat> activeChats, int currentUser) {
		System.out.println("-- getOtherUsersArray() called --");
		String[] otherUsers = new String[activeChats.size()];
		for (int i = 0; i <= activeChats.size(); i++) {
			Student user;
			if(activeChats.get(i).getUser1Id() == currentUser) {
				user = DBUtility.getStudent(activeChats.get(i).getUser2Id());
				otherUsers[i] = user.getUserName();
			}
			else {
				user = DBUtility.getStudent(activeChats.get(i).getUser1Id());
				otherUsers[i] = user.getUserName();
			}
		}
		
		return otherUsers;
	}
	
	//When given an ArrayList of Chat objects and a userId, this method returns the usernames of the other user in the chat 
	public static List<Student> getOtherUsers(List<Chat> activeChats, int currentUser) {
		System.out.println("-- getOtherUsers() called --");
		List<Student> otherUsers = new ArrayList<Student>();
		for (int i = 0; i < activeChats.size(); i++) {
			Student otherUser = null;
			if(activeChats.get(i).getUser1Id() == currentUser) {
				otherUser = DBUtility.getStudent(activeChats.get(i).getUser2Id());
				otherUsers.add(otherUser);
			}
			else {
				otherUser = DBUtility.getStudent(activeChats.get(i).getUser2Id());
				otherUsers.add(otherUser);
			}
		}
		return otherUsers;
	}
	
	//Attempts to create a chatroom when given 2 userIds. Returns false if the chatroom already exists
	public static boolean createChatroom(Student user1, Student user2) {
		System.out.println("-- createChatroom() called --");
		if (ChatMessageDAO.getChatWithUserIds(user1.getUserId(), user2.getUserId()) == null) {
			ChatMessageDAO.insertChat(user1, user2);
			return true;
		}
		System.out.println("Chat already exists or there was an error with the database! Returning false.");
		return false;
	}

}
