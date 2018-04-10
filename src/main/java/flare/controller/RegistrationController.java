package flare.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import flare.factory.StudentFactory;
import flare.model.encryption.PasswordEncryption;
import flare.model.encryption.TokenGenerator;
import flare.model.mail.Mailer;
import flare.model.users.Student;
import flare.services.registration.RegistrationService;


@Controller
public class RegistrationController {

	StudentFactory students = new StudentFactory(); // reference to grab a student object
	
	@Autowired 
	Mailer mailer;
	
	@Autowired
	PasswordEncryption passwordEncryption;
	
	@Autowired
	RegistrationService registrationService;
	/**
	 * 
	 * @return maps /registration url to registration page
	 */
	@RequestMapping( value = "/registration")
	public String registration() {
		
		return "/registrationPage";
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView registrationException() {
		
		ModelAndView errorModel = new ModelAndView("/registrationError");
		
		errorModel.addObject("errorMsg", "You have entered an unreadable email or that user is already registered in the database, please try again!");
		
		return errorModel;
		
	}
	
	// registration verification
	@RequestMapping(value = "/registrationValidation")
	public ModelAndView registrationValidation(
			@RequestParam("username") String uname,
			@RequestParam("password") String pword,
			@RequestParam("firstname") String fname,
			@RequestParam("lastname") String lname,
			@RequestParam("year") String yr,
			@RequestParam("semester") String sem, 
			@RequestParam("email") String address,
			@Autowired TokenGenerator tokenGenerator
			) {
		
		// generate the token
		String token = tokenGenerator.getSaltString();
		
		// instantiate two models, one for errors in form, another for authorized form
		ModelAndView authorizedModel = new ModelAndView("/registrationVerification");
		ModelAndView errorModel = new ModelAndView("/registrationError");
		
		// server validate fields here if false add error message and return form for re-entry
		if(!registrationService.isSemester(sem)) {
			
			errorModel.addObject("errorMsg", "You have entered an invalid semester, only single digit numbers are allowed ");
			
			return errorModel;
		}
		if(!registrationService.isYear(yr)) {
			
			errorModel.addObject("errorMsg", "You have not entered a valid year, only single digit numbers are be allowed");
				
			return errorModel;
		}
		if(!registrationService.isEmail(address)) {
			
			errorModel.addObject("errorMsg", "Your email must be from george brown college in the format xxxxxx@georgebrown.ca ");
			
			return errorModel;
		}
		// here, the page learns about the token generated
		authorizedModel.addObject("token", token);
		authorizedModel.addObject("username", uname);
		authorizedModel.addObject("password", pword);
		authorizedModel.addObject("firstname", fname);
		authorizedModel.addObject("lastname", lname);
		authorizedModel.addObject("semester", sem);
		authorizedModel.addObject("year", yr);
		authorizedModel.addObject("email", address);
		
		// mail the token to target
				mailer.registerMail(address, token);
				
		return authorizedModel;
	}
	
	
	// validate the token, set cookie and session variables, control flow between success 
	@RequestMapping(value = "/registrationVerification")
	public ModelAndView registrationVerification(
			@RequestParam("username") String username,
			@RequestParam("tokenFromUser") String userToken,
			@RequestParam("password") String password,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("year") String year,
			@RequestParam("semester") String semester, 
			@RequestParam("email") String email,
			@RequestParam("token") String token,
			@Autowired Student student,
			HttpServletResponse response) throws Exception {
		
		// instantiate two models, one for errors in form, another for authorized form
				ModelAndView registrationSuccess = new ModelAndView("/registrationSuccess");
				ModelAndView registrationFailure = new ModelAndView("/registrationError");
				
				if(userToken.equals(token)) {
					
					// cookies
					response.addCookie(new Cookie("username", username));
					response.addCookie(new Cookie("password", password));
					
					// configure student object and write to the database
					Student registerStudent = students.getObject();
					
					registerStudent.setUserName(username);
					registerStudent.setPassword("{bcrypt}"+passwordEncryption.bcryptHash(password));
					registerStudent.setFirstName(firstname);
					registerStudent.setLastName(lastname);
					registerStudent.setCurrentYear(Integer.parseInt(year));
					registerStudent.setSemester(Integer.parseInt(semester));
					registerStudent.setEmail(email);
					registerStudent.setEnabled(1);
					
					// todays date
					Date date = new Date();
					
					
					registerStudent.setAccountCreation(registrationService.removeTime(date));
					//registerStudent.setAccountCreation(today);
					registerStudent.setAuthority("ROLE_STUDENT");
					
					// write to database
					registerStudent.DB().insertDB();
					
					//store username in session
					registrationSuccess.addObject("user",username);
					
					//return success page
					return registrationSuccess;
				}
				
				// elser create session and cookie
				else {
					
					// put errMsg
					registrationFailure.addObject("errorMsg","Your token value does not match, please re-enter your information");
					System.out.println(userToken);
					System.out.println(token);
					// return failure page
					return registrationFailure;
				}
				
	}
	
}
