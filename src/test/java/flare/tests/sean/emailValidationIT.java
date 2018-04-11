package flare.tests.sean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class emailValidationIT {

	@Test
	public void test() {
		
		// prove false
		String pattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@georgebrown.ca";
		 Pattern p = Pattern.compile(pattern);
		 Matcher m = p.matcher("sdfgsdf234@yahoo.ca");
		 boolean b = m.matches();
		
		 // prove true
		    Matcher a = p.matcher("sean.dougan@georgebrown.ca");
			boolean o = a.matches();
			
		 System.out.println(o);
		 System.out.println(b);	
		
	}

}
