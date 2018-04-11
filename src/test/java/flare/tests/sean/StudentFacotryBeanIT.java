package flare.tests.sean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import flare.model.users.Admin;
import flare.model.users.ClubLeader;
import flare.model.users.Student;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class StudentFacotryBeanIT {

	@Autowired
	Student student;
 @Autowired
 ClubLeader clubleader;
 @Autowired
 Admin admin;
	
	@Test
	public void test() {
		
		System.out.println(student);
		
		System.out.println(student.DB());
		
		
		System.out.println(student.DB().getStudentDataMap());
		
		System.out.println(clubleader);
		
		System.out.println(clubleader.DB());
		
		
		System.out.println(clubleader.DB().getclDataMap());
		
		System.out.println(admin);
		
		System.out.println(admin.DB());
		
		
		System.out.println(admin.DB().getAdminDataMap());
		
		admin.DB().bindObjectToDB("babyhands");
		
	
		
		

	}

}
