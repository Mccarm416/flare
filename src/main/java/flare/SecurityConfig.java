package flare;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import flare.model.users.Student;

@Configuration
@EnableWebSecurity
public class SecurityConfig
	extends WebSecurityConfigurerAdapter {

	@Autowired 
	DataSource c3p0DataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(c3p0DataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/admin").hasRole("ADMIN")
		.antMatchers("/maps",	
				"/timePage",
				"/home",
				"/agenda",
				"/chat",
				"/notes",
				"/reports",
				"/insertTime",
				"/notes",
				"/notesUpload",
				"/notesDownload",
				"/notesDelete",
				"/inbox",
				"/userSearch",
				"/chatroom",
				"/recTimes",
				"/etime",
				"Timer",
				"/timer",
				"/study",
				"/timetable").hasAnyRole("STUDENT","CL")
        .antMatchers("/registrationValidation",
        		"/registration",
        		"/userSearch",
        		"/getCourseList",
        		"getCourseList",
        		"Timer",
        		"/",
        		"/notes",
				"/notesUpload",
				"/notesDownload",
				"/notesDelete",
				"/inbox",
				"/chatroom",
        		"/postTime",
        		"/registrationSuccess.jsp",
        		"/registrationError.jsp",
        		"/registrationVerification").permitAll()
        .anyRequest().authenticated(). 
		and().formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/welcome", true)
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/forbidden");
		
	}

	 @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/resources/**","/registrationError","/registrationSuccess", 
	        		 "/registrationValidation", "/registrationVerification", "/notes",
	 				"/notesUpload",
					"/notesDownload",
					"/notesDelete",
					"/inbox",
					"/userSearch",
					"/chatroom",
					"/recTimes",
					"/getCourseList",
	        		"getCourseList"); // #3
	  }
	

}
