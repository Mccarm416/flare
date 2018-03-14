package flare.model.users.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminDAO extends UserDAO {
	
	//TODO private list variable to hold result set using RowMapper API
	@Autowired
	public AdminDAO(DataSource dataSource) {
		
		super(dataSource);
	}

	//TODO CRUD methods
}
