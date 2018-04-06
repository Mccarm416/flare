package flare.tests.sean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import flare.model.mail.Mailer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class MailerIT {
	
	@Autowired
	Mailer mailer;
	
	
	@Test
	public void test() {
		
	mailer.registerMail("seandougan@georgebrown.ca", "1234562134");
		
	}

}
