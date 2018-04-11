package flare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		System.out.println("--- inbox() called ---");
		//Get users that the current user has an active chat with
		List<Chat> activeChats = ChatMessageDAO.getActiveChats(1);
		List<Student> chatUsers = ChatUtility.getOtherUsers(activeChats, 1);
		model.addAttribute("chatUsers", chatUsers);
		return "inbox";
	}
	
	@RequestMapping("/userSearch")
	public String userSearch(@Autowired @Qualifier("student") Student searchedUser, @Autowired @Qualifier("student") Student currentUser, HttpServletRequest request, Model model) {
		System.out.println("--- userSearch() called ---");
		// -- PULL USER FROM SESSION --
		currentUser.DB().bindObjectToDB("bourgeois.goblin");
		//Searches to see if user exists and creates a chatroom with them if one is not already existing
		String findUser = request.getParameter("userFind");
		searchedUser.DB().bindObjectToDB(findUser);
		//Check to see if a user was submitted
		if(searchedUser.getUserName() != null) {
			//Check if the chatroom exists and create it if it does not
			boolean check = ChatUtility.createChatroom(currentUser, searchedUser);
			if (check) {
				model.addAttribute("currentUser", currentUser.getUserId());
				model.addAttribute("selectedUser", searchedUser.getUserName());
				model.addAttribute("messages", null);
				return "chatroom";
			}
		}
		List<Chat> activeChats = ChatMessageDAO.getActiveChats(1);
		List<Student> chatUsers = ChatUtility.getOtherUsers(activeChats, currentUser.getUserId());
		model.addAttribute("chatUsers", chatUsers);
		model.addAttribute("errorMessage", "User '" + findUser +"' was not found.");
		return "inbox";
	}
	
	//Opens the chatroom
	@RequestMapping("/chatroom")
	public String chatroom(@Autowired @Qualifier("student") Student currentUser, @Autowired @Qualifier("student") Student selectedUser, HttpServletRequest request, Model model) {
		System.out.println("--- chatroom() called ---");
		//Get the current user and pass it to the JSP
		currentUser.DB().bindObjectToDB("bourgeois.goblin");
		model.addAttribute("currentUserId", currentUser.getUserId());
		//Get the selected user to chat with
		String selectedUserName = request.getParameter("selectedUser");
		selectedUser.DB().bindObjectToDB(selectedUserName);
		model.addAttribute("selectedUser", selectedUser);
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
		
		return "chatroom";
	}
	
}
