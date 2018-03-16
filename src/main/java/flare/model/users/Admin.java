package flare.model.users;

import org.springframework.beans.factory.annotation.Autowired;

import flare.model.users.dao.AdminDAO;

public class Admin extends User {
	
	// fields
		@Autowired
		protected AdminDAO dao; // reference to users DAO, will appropriate which with injection in specialized classes

}
