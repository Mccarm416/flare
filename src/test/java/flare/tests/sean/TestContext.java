package flare.tests.sean;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import flare.factory.AdminFactory;
import flare.factory.ClubLeaderFactory;
import flare.factory.StudentFactory;
import flare.model.users.Student;

import org.springframework.context.annotation.ComponentScan;


@Configuration
@ComponentScan(basePackages = {"flare.factory", "flare.model", "flare.dataaccess"})
public class TestContext {	
	
@Bean
public DataSource dataSource() {
	
	
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/flaredb");
    dataSource.setUsername("admin");
    dataSource.setPassword("admin");
     
    return dataSource;
}

@Bean
public StudentFactory student() {
	
	StudentFactory student = new StudentFactory();
	return student;
}

@Bean
public AdminFactory admin() {
	
	AdminFactory admin = new AdminFactory();
	return admin;
}

@Bean
public ClubLeaderFactory clubleader() {
	
	ClubLeaderFactory clubleader = new ClubLeaderFactory();
	return clubleader;
}

}
