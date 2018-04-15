package flare.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import flare.dataaccess.FlareDB;

@Controller
public class AdminPanelController {

	@GetMapping("/admin")
	public String getAdmin() {
		
		return "/adminPanel";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/admin")
	public ModelAndView postAdmin(@RequestParam("username")String username,
			@RequestParam("ban")String ban){
	
		String sql = "SELECT userid, users.username, `password`, email, firstname, lastname, accountcreation,"
	  			  + " displaypicture, enabled, currentyear, semester, authority"
	  			   +" FROM users"
	  			  +"  JOIN authorities"
	  			  + " ON users.username = authorities.username";
		
		ModelAndView admin = new ModelAndView("/adminPanel");
		
		admin.addObject("msg", "No such user");
		try {
		List<Map<String,Object>> list = FlareDB.getJdbc().queryForList(sql);
  		
  		for(int index = 0 ; index < list.size() ; index++){
  	        Map<String, Object> listItem = list.get(index);
  	        
  	        if(username.equals(listItem.get("username"))){
  	        	
  	        	String update;
  	        	
  	        	if(ban.equals("Die!")) {
  	        	update = "UPDATE users set enabled = 0 WHERE username = ?";
  	        	admin.addObject("msg",username + " banned!");
  	        	}
  	        	
  	        	else {
  	        		update = "UPDATE users set enabled = 1 WHERE username = ?";
  	        		admin.addObject("msg",username + " unbanned!");
  	        	}
  	        	System.out.println("Attempting update");
  	        	FlareDB.getJdbc().update(update, username);
  	        	System.out.println("Updating sql");
  	        	
  	        }
  	        
  		}
  		
  	
  			
  
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return admin;
		
	}
	
	@ExceptionHandler(Exception.class)
	public String adminnException() {
		
		return "/adminPanel";
		
	}
	
	@RequestMapping("/forbidden")
	public String forbidden() {
		
		return "403";
	}
}
