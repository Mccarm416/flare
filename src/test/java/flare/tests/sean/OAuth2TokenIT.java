package flare.tests.sean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import flare.model.encryption.TokenGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class OAuth2TokenIT {

	@Autowired
	TokenGenerator tokenGenerator;
	@Test
	public void test() {
		//1
		System.out.println(tokenGenerator.getSaltString());
		//2
		System.out.println(tokenGenerator.getSaltString());
		//3
		System.out.println(tokenGenerator.getSaltString());
	}

}
