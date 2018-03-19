package flare.factory;

import org.springframework.beans.factory.FactoryBean;
import flare.model.users.Student;

public class StudentFactory implements FactoryBean<Student>{

	@Override
	public Student getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Student> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

}
