package flare.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flare.messaging.ChatMessage;
import flare.model.users.Student;
import flare.model.users.User;

@Controller
public class InboxController {

	@RequestMapping("/inbox")
	public String inbox(Model model){
		ArrayList<Student> chatUsers = new ArrayList<Student>();
		Student user1 = new Student(1, "RL Grime", "Henry", "Steinway");
		Student user2 = new Student(2, "whatSoNot", "Chris", "Emerson");
		chatUsers.add(user1);
		chatUsers.add(user2);
		model.addAttribute("chatUsers", chatUsers);
		return "inbox";
	}
	
	
	@RequestMapping("/chatroom")
	public String chatroom(HttpServletRequest request, Model model) {
		//Get the current user and pass it to the JSP
		//FIX - Using a dummy user right now.
		Student currentUser = new Student(0, "mccarm416", "Matthew", "McCarthy");		
		model.addAttribute("currentUserId", currentUser.getUserId());
		//Get the selected user to chat with
		String userChat = request.getParameter("selectedUser");
		model.addAttribute("userChat", userChat);
		//Add ArrayList of messages pulled from database
		//FIX - Using dummy messages
		ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();
		if (userChat.equals("RL Grime")) {
			ChatMessage message = new ChatMessage("mccarm416", 0, "Yo RL, you're new stuff is bumpin!");
			messages.add(message);
			message = new ChatMessage ("RL Grime", 1, "Thanks man, you coming to my show this Friday?");
			messages.add(message);
			message = new ChatMessage("mccarm416", 0, "Yeah man!");
			messages.add(message);
			message = new ChatMessage("RL Grime", 1, "Sick man, I'll see you there");
			messages.add(message);
		}
		else if (userChat.equals("whatSoNot")) {
			ChatMessage message = new ChatMessage("whatSoNot", 3, "Hey man");
			messages.add(message);
			message = new ChatMessage("whatSoNot", 3, "I'm back home in Australia for the break");
			messages.add(message);
			message = new ChatMessage("whatSoNot", 3, "How did the Swift test go for you?");
			messages.add(message);
			message = new ChatMessage("mccarm416", 0, "Really bad");
			messages.add(message);
			message = new ChatMessage("mccarm416", 0, "I dunno anyone who said they killed it lol");
			messages.add(message);
			message = new ChatMessage("whatSoNot", 3, "Lol me either man. It was really tough. Swift makes no sense to me!");
			messages.add(message);
		}
		model.addAttribute("messages", messages);
		
		return "chatroom";
	}
}
