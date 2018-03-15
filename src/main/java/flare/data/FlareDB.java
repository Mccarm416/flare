package flare.data;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class FlareDB {

	//DATABASE CONNECTION STRINGS
		private final static String username = "admin";
		private final static String password = "admin";
		private final static String database = "flare_db";
		
		//SINGLETON CONNECTION TO DATABASE
		public static Connection startConnection() {
			
			try {
			      // This will load the MySQL driver, each DB has its own driver
				System.out.println("Initializing MYSql Driver JAR...");
			      Class.forName("com.mysql.jdbc.Driver");
			      
			      // Setup the connection with the DB
			      System.out.println("Driver found! Establishing Connection ...");
			      final Connection connect = (Connection) DriverManager.getConnection(""
			      		+ "jdbc:mysql://localhost:3306/"+database+"?"
				              + "user="+username+"&password="+password);
			      
			     //returns connection
			      System.out.println("Connection Established");
			      return connect;
			    } 
			catch (Exception e) {
			      
			    	System.out.println("There is a problem connecting to the MYSql database");
			    	return null;
			    } 
		}
		
	
}