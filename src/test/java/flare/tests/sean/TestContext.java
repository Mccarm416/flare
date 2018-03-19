package flare.tests.sean;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import flare.factory.StudentFactory;

import org.springframework.context.annotation.ComponentScan;


@Configuration
@ComponentScan(basePackages = {"flare.factory", "flare.model", "flare.dataaccess"})
public class TestContext {	
	

	 	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "admin";
	    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/flaredb";
	    private static final String PROPERTY_NAME_DATABASE_USERNAME = "admin";
@Bean
public DataSource dataSource() {
	
	
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/flaredb");
    dataSource.setUsername("admin");
    dataSource.setPassword("admin");
     
    return dataSource;
}
}
