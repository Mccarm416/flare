package flare.tests.sean;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;

import flare.factory.AdminFactory;
import flare.factory.ClubLeaderFactory;
import flare.factory.StudentFactory;
import flare.model.users.Student;

import org.springframework.context.annotation.ComponentScan;

@ImportResource("classpath:flare/tests/sean/TestConfig.xml")
@ComponentScan(basePackages = {"flare"})
@Configuration
public class TestContext {	
	



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
