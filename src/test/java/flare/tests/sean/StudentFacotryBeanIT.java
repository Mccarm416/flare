package flare.tests.sean;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import flare.dataaccess.FlareDB;
import flare.factory.StudentFactory;
import flare.model.users.Admin;
import flare.model.users.ClubLeader;
import flare.model.users.Student;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class StudentFacotryBeanIT {

	@Autowired
	@Qualifier("student")
	Student jamie;
	
 

	
	@Test
	public void test() {
		
		try {
			
			// this is the class doing the autowiring - can also physically instantiate to get as many objects as you want
		 StudentFactory studentFactory = new StudentFactory();
		 
		// jamie from the autowired
		System.out.println(jamie.getFirstName());
		
		jamie.DB().bindObjectToDB("babyhands");
		
		System.out.println(jamie.getFirstName());
		
		
		// another object from factory dependency
		
	Student greg =	studentFactory.getObject();
	
	System.out.println(greg.getFirstName());
	
	greg.DB().bindObjectToDB("sku11d3stroy3r");
	
	System.out.println(greg.getFirstName());

	
	// a third from factory dependency
	
	Student michael =	studentFactory.getObject();
	
	System.out.println(michael.getFirstName());
	
	michael.DB().bindObjectToDB("78uh");
	
	System.out.println(michael.getFirstName());
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
