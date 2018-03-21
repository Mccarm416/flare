package flare.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flare.messaging.Chat;
import flare.messaging.ChatMessage;
import flare.messaging.ChatMessageDAO;
import flare.messaging.ChatUtility;
import flare.model.users.Student;

@Controller
public class InboxController {

	@RequestMapping("/inbox")
	public String inbox(Model model){
		//Get users that the current user has an active chat with
		ArrayList<Chat> activeChats = ChatMessageDAO.getActiveChats(1);
		ArrayList<Student> chatUsers = ChatUtility.getOtherUsers(activeChats, 1);
		model.addAttribute("chatUsers", chatUsers);
		return "inbox";
	}
	
	@RequestMapping("/userSearch")
	public String userSearch(HttpServletRequest request, Model model) {
		System.out.println("/userSearch called");
		Student currentUser = new Student(1, "mccarm416", "Matthew", "McCarthy");
		//Searches to see if user exists and creates a chatroom with them if one is not already existing
		String findUser = request.getParameter("userFind");
		//Check to see if a user was submitted
		if(findUser != null) {
			//Search for the found user in the DB
			Student foundUser = ChatMessageDAO.searchUsername(findUser);
			if (foundUser != null) {
				//Check if the chatroom exists and create it if it does not
				boolean check = ChatUtility.createChatroom(currentUser, foundUser);
				if (check) {
					model.addAttribute("currentUser", currentUser.getUserId());
					model.addAttribute("selectedUser", foundUser.getUsername());
					model.addAttribute("messages", null);
					return "chatroom";
				}
			}
		}
		ArrayList<Chat> activeChats = ChatMessageDAO.getActiveChats(1);
		ArrayList<Student> chatUsers = ChatUtility.getOtherUsers(activeChats, 1);
		model.addAttribute("chatUsers", chatUsers);
		model.addAttribute("errorMessage", "User '" + findUser +"' was not found.");
		return "inbox";
	}
	
	@RequestMapping("/chatroom")
	public String chatroom(HttpServletRequest request, Model model) {
		//Opens the chatroom
		//Get the current user and pass it to the JSP
		Student currentUser = new Student(1, "mccarm416", "Matthew", "McCarthy");		
		model.addAttribute("currentUserId", currentUser.getUserId());
		//Get the selected user to chat with
		String selectedUser = request.getParameter("selectedUser");
		Student otherUser = ChatMessageDAO.searchUsername(selectedUser);
		model.addAttribute("selectedUser", selectedUser);
		System.out.println(selectedUser + currentUser);
		//Find their chat
		Chat chat = ChatMessageDAO.getChatWithUserIds(currentUser.getUserId(), otherUser.getUserId());
		System.out.println("Chat =  " + chat.getUser1Id() + chat.getUser2Id());
		//Add message to the database if one was sent
		if(request.getParameterMap().containsKey("message")) {
			System.out.println("message found");
			String message = request.getParameter("message");
			System.out.println("Message = " + message);
			ChatMessage newMessage = new ChatMessage(chat.getChatId(), currentUser.getUserId(), currentUser.getUsername(), otherUser.getUserId(), otherUser.getUsername(), message);
			ChatMessageDAO.insertMessage(newMessage);
			
		}
		//Add ArrayList of messages pulled from database
		ArrayList<ChatMessage> messages = ChatMessageDAO.getChatMessages(chat.getChatId()); 
		model.addAttribute("messages", messages);
		
		return "chatroom";
	}
	
}
