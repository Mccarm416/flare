package flare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import flare.model.users.Student;
import flare.model.users.User;

@Controller
public class InboxController {

	@RequestMapping("/inbox")
	public String inbox(){
		return "inbox";
	}
	
	@RequestMapping("/chatroom")
	public String chatroom() {
		return "chatroom";
	}
}
