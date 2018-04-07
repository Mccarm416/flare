package flare.services.registration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	private final String pattern = "^^[\\w.+\\-]+@georgebrown\\.ca$";
			
	Pattern gbcEmailValidation = Pattern.compile(pattern);
	
	// check if the number can be converted to an integer
	private boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

	
	// check if digit is a single digit
	private boolean isSingleDigit(String number) {
		
		int comparator = Integer.parseInt(number);
		
		if(comparator >= 10 || comparator <= 0) {
			
			return false;
		}
		return true;
	}
	
	// next method
	public boolean isYear(String year) {
		
		if(isInteger(year) && isSingleDigit(year)) {
			
			return true;
		}
		
		return false;
	}
	
	// is semester
	public boolean isSemester(String semester) {
		
		if(isInteger(semester) && isSingleDigit(semester)) {
			
			return true;
		}
		
		return false;
	}
	public boolean isEmail(String email) {
		
		Matcher matchesEmailPattern = gbcEmailValidation.matcher(email);
		boolean isEmail = matchesEmailPattern.matches();
		
		return isEmail;
	}
	
	public String removeTime(Date date) {

		DateFormat df = new SimpleDateFormat("yyy-MM-dd");
		String dateSql = df.format(date);
		
		return dateSql;
    }
}
