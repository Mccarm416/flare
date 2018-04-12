package flare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flare.factory.StudentFactory;
import flare.messaging.Chat;
import flare.messaging.ChatMessage;
import flare.messaging.ChatMessageDAO;
import flare.messaging.ChatUtility;
import flare.model.users.Student;

@Controller
public class InboxController {

	@RequestMapping("/inbox")
	public String inbox(Model model){
		System.out.println("--- InboxController.inbox() called ---");
		//FIX TO USE SESSIONS - Create dummy student
		StudentFactory sf = new StudentFactory();
		Student currentUser;
		int currentUserId;
		try {
			currentUser = sf.getObject();
			currentUser.DB().bindObjectToDB("svoogan");
			currentUserId = currentUser.getUserId();
			//Get users that the current user has an active chat with
			List<Chat> activeChats = ChatMessageDAO.getActiveChats(currentUserId);
			List<Student> chatUsers = ChatUtility.getOtherUsers(activeChats, currentUserId);
			model.addAttribute("chatUsers", chatUsers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*-- Returning inbox.jsp --*");
		return "inbox";
	}
	
	//Searches to see if user exists and creates a chatroom with them if one is not already existing
	@RequestMapping("/userSearch")
	public String userSearch(HttpServletRequest request, Model model) {
		System.out.println("--- InboxController.userSearch() called ---");

		try {
			//Get the users in the chat
			//FIX TO USE SESSIONS - Create dummy student
			StudentFactory sf = new StudentFactory();
			Student currentUser = sf.getObject();
			Student searchedUser = sf.getObject();
			String findUser = request.getParameter("userFind");
			searchedUser.DB().bindObjectToDB(findUser);
			currentUser = sf.getObject();
			currentUser.DB().bindObjectToDB("svoogan");
			//Check to see if a user was submitted
			if(searchedUser.getUserName() != null) {
				//Check if the chatroom exists and create it if it does not
				boolean check = ChatUtility.createChatroom(currentUser, searchedUser);
				if (check) {
					model.addAttribute("currentUser", currentUser.getUserId());
					model.addAttribute("selectedUser", searchedUser.getUserName());
					model.addAttribute("messages", null);
					System.out.println("*-- Returning chatroom.jsp --*");
					return "chatroom";
				}
			}
			List<Chat> activeChats = ChatMessageDAO.getActiveChats(currentUser.getUserId());
			List<Student> chatUsers = ChatUtility.getOtherUsers(activeChats, currentUser.getUserId());
			model.addAttribute("chatUsers", chatUsers);
			model.addAttribute("errorMessage", "User '" + findUser +"' was not found.");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("*-- Returning inbox.jsp --*");
		return "inbox";
	}
	
	//Opens the chatroom
	@RequestMapping("/chatroom")
	public String chatroom(HttpServletRequest request, Model model) {
		System.out.println("--- InboxController.chatroom() called ---");
		
		
		//Get the selected user to chat with
		String selectedUserName = request.getParameter("selectedUser");
		try {		
			//FIX TO USE SESSIONS - Create dummy student
			StudentFactory sf = new StudentFactory();
			Student currentUser = sf.getObject();
			Student selectedUser = sf.getObject();
			currentUser.DB().bindObjectToDB("svoogan");
			model.addAttribute("currentUserId", currentUser.getUserId());

			selectedUser.DB().bindObjectToDB(selectedUserName);
			model.addAttribute("selectedUser", selectedUserName);
			//Find their chat
			Chat chat = ChatMessageDAO.getChatWithUserIds(currentUser.getUserId(), selectedUser.getUserId());
			System.out.println("Chat =  " + chat.getUser1Id() + chat.getUser2Id());
			//Add message to the database if one was sent
			if(request.getParameterMap().containsKey("message")) {
				System.out.println("message found");
				String message = request.getParameter("message");
				System.out.println("Message = " + message);
				ChatMessage newMessage = new ChatMessage(chat.getChatId(), currentUser.getUserId(), currentUser.getUserName(), selectedUser.getUserId(), selectedUser.getUserName(), message);
				ChatMessageDAO.insertMessage(newMessage);
				
			}
			//Add ArrayList of messages pulled from database
			List<ChatMessage> messages = ChatMessageDAO.getChatMessages(chat.getChatId()); 
			model.addAttribute("messages", messages);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("*-- Returning chatroom.jsp --*");
		return "chatroom";
	}
	
}
