/**
 * This class handles the data initialization for all user objects. This class uses a configured
 * datasource from flare-config.xml in order to instantiate a consistent connection.
 * <p>
 * During initialization, the pre-configured datasource is passed using autowired constructor
 * injection.
 * <p>
 * CRUD operations are implemented and designed to be used with its corresponding model object
 * 
 * @author Sean Dougan
 * @version 3.0
 * @since 1.0
 */
package flare.model.users.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class UserDAO {
	
	// fields
	// #####################################################################################
	protected JdbcTemplate jdbc; // only one single field is required, a jdbc template
	
	// methods
	// ######################################################################################
	/*
	 *  Using constructor injection, the data source defined in flare-config.xml is passed in
	 *  during initialization of the object and assigned to the jdbc template. There is only
	 *  one single data source in the configuration, so simple autowiring will be the most
	 *  efficient. This is a PRIVATE CONSTRUCTOR.
	 */
		public UserDAO(DataSource dataSource) {
			
			// here we simply assign the jdbc template to the already autowired data source
			jdbc = new JdbcTemplate(dataSource);
		}
	// this method returns the jdbc template, it is private
	protected JdbcTemplate getJdbc() {
		return this.jdbc;
	}

	
}
