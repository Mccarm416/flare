package flare.model.users;

import flare.dataaccess.UserDAO;
/**
 * 
 * @author Sean Dougan
 * @version 3.0
 * @since 1.0
 * This class student contains an inner class of its data access object StudentDAO. StudentDAO inherits from UserDAO -
 * an abstraction class meant to regulate the use of specific user access and functions on the database.
 */
// START OF OUTER
public class Student extends User implements MutateAccountType, AccountManagement {
	
	// fields
	private StudentDAO studentdao;
	

	// methods
	
	public void setStudentDAO(StudentDAO studendao) {
	
	}

	
//  START OFINNER CLASS
	
	public class StudentDAO extends UserDAO {
		
	public StudentDAO() {
		
	
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void bindStudent() {}
		
	
	
	}
	// END OF INNER

}
// END OF OUTER
