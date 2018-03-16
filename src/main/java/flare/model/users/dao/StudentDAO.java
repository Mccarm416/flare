package flare.model.users.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import flare.model.users.Student;


@Component("studentdao")
@Scope("prototype")
public class StudentDAO extends UserDAO {
	
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
	public StudentDAO(DataSource dataSource)  {
		
		super(dataSource);
	}

	// GET/SET
	// STUDENT
	public Student getStudent() {
	return student;
	
	}

	public void setStudent(Student student) {
		this.student = student;
		
	}
	
	public void update(String username) {}
	
	public void delete(String username) {}

	
	
}
