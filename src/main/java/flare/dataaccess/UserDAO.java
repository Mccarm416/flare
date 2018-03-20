package flare.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * @author Sean Dougan
 * @version 3.0
 * @since 1.0
 * This abstract class is meant to provide a single usable jdbc template configured with the method contracts to use it.
 * This class is only meant to be inherited as users
 */
public abstract class UserDAO{
	
		// fields
		protected JdbcTemplate userDBC;// references the static singleton configured jdbc connection
	/*
	 * 	constructor simply initializes a local refernece to the static singleton data connection for the site
	 */
	public UserDAO()  {
		
		userDBC = (FlareDB.getJdbc());
	}

	// CRUD methods
	/**
	 * inserts new user to the database with the current values of the callers fields
	 */
	abstract protected void insertDB();
	
	/**
	 * select your own records from the database with the current values of the callers fields
	 */
	abstract protected void bindObjectToDB(String username );
	
	/**
	 * update your own records from the database with the current values of the callers fields
	 */
	abstract protected void updateDB(String username);
	
	/**
	 * delete your own records from the database with the current values of the callers fields
	 */
	abstract protected  void deleteDB();
}
