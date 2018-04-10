package flare.tests.sean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import flare.model.encryption.PasswordEncryption;
import flare.model.encryption.TokenGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class OAuth2TokenIT {

	@Autowired
	TokenGenerator tokenGenerator;
	
	@Autowired 
	PasswordEncryption passwordEncryption;
	@Test
	public void test() {
		//1
		System.out.println(tokenGenerator.getSaltString());
		//2
		System.out.println(tokenGenerator.getSaltString());
		//3
		System.out.println(tokenGenerator.getSaltString());
		
		String apples = "apples";
		
		apples = passwordEncryption.bcryptHash(apples);
		
		System.out.println(apples);
	}

}
