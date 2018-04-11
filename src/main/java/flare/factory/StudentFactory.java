package flare.factory;

import org.springframework.beans.factory.FactoryBean;
import flare.model.users.Student;
import flare.model.users.Student.StudentDAO;
import flare.model.users.Student.StudentDAO.StudentRowMapper;

public class StudentFactory implements FactoryBean<Student>{

	@Override
	public Student getObject() throws Exception {
		
			Student student = new Student();
			StudentDAO studentdao =	student.new StudentDAO();
			StudentRowMapper studentrm = studentdao.new StudentRowMapper();
			
			studentdao.setStudentDataMap(studentrm);
			student.setStudentDAO(studentdao);
			return student;
	}

	@Override
	public Class<Student> getObjectType() {
		// TODO Auto-generated method stub
		return Student.class;
	}
	
	public boolean isSingleton() { return false; }

}
