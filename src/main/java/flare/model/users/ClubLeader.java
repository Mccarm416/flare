package flare.model.users;

import org.springframework.beans.factory.annotation.Autowired;

import flare.model.users.dao.ClubLeaderDAO;

public class ClubLeader extends User {

	// fields
		@Autowired
		protected ClubLeaderDAO dao; // reference to users DAO, will appropriate which with injection in specialized classes
}
