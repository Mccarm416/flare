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
package flare.dataaccess;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("flareDB")
@Scope("singleton")
public class FlareDB {
	
	// fields
	// #####################################################################################
	private  static JdbcTemplate jdbc; // only one single field is required, a jdbc template
	
	// methods
	// ######################################################################################
	/**
	 * 
	 * @param dataSource data source will be auto-wired from bean configuration in flare-config.xml
	 */
		@Autowired
		private FlareDB(DataSource dataSource) {
			
			System.out.println("injecting datasource from spring bean ...");
			// here we simply assign the jdbc template to the already autowired data source
			jdbc = new JdbcTemplate(dataSource);
			
			System.out.println("datsource bound to global jdbc template!");
		}
	/**
	 * 
	 * @return returns the JdbcTemplate object, only for DAO classes
	 */
	public static JdbcTemplate getJdbc() {
		
		return jdbc;
	}
			
}
