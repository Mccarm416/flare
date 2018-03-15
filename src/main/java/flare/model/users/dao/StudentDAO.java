package flare.model.users.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import flare.model.users.Student;

@Component
public class StudentDAO extends UserDAO {
	
	//TODO private list variable to hold result set using RowMapper API
		// fields
		// #####################################################################################
		private Student student;
	
		// methods
		// ######################################################################################
		/*
		 *  Using constructor injection, the data source defined in flare-config.xml is passed in
		 *  during initialization of the object and assigned to the jdbc template. There is only
		 *  one single data source in the configuration, so simple autowiring will be the most
		 *  efficient. This is a PRIVATE CONSTRUCTOR.
		 */
		/**
		 * 
		 * @param dataSource
		 */
	@Autowired
	public StudentDAO(DataSource dataSource) {
		
		super(dataSource);
	}

	// GET/SET
	// setter is used to set student object to current student object in use

	public void setStudent(Student student) {
		this.student = student;
	}

	//TODO CRUD methods
	
	
}
