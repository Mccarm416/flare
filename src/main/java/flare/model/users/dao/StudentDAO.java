package flare.model.users.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class StudentDAO extends UserDAO {
	
	//TODO private list variable to hold result set using RowMapper API
		// fields
		// #####################################################################################
	
		// methods
		// ######################################################################################
		/*
		 *  Using constructor injection, the data source defined in flare-config.xml is passed in
		 *  during initialization of the object and assigned to the jdbc template. There is only
		 *  one single data source in the configuration, so simple autowiring will be the most
		 *  efficient. This is a PRIVATE CONSTRUCTOR.
		 */
	public StudentDAO(DataSource dataSource) {
		
		super(dataSource);
	}

	//TODO CRUD methods
}