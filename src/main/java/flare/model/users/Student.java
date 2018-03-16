package flare.model.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import flare.model.users.dao.StudentDAO;

@Component("student")
@Scope("prototype")
public class Student extends User implements RowMapper<Student>, MutateAccountType, AccountManagement {
	
	// fields

	@Autowired
	private Student student;

	private StudentDAO studentdao;

	// methods
	@Autowired
	public Student(@Lazy Student student, StudentDAO studentdao) {
		
		this.student = student;
		this.studentdao.setStudent(this.student);
		
	}

	// class is now initialized with its proper coupling in regards to state messaging
	// RowMapper is implemented in the student class as to bind the current instance to the data
	/*@Override
	private Student mapRow(ResultSet rs, int rownum) throws SQLException {
		
		// map the student fields, a singleton reference, fields to the result set
		super.setUserName(rs.getString("userName"));
		super.setPword(rs.getString("pword"));
		super.setAccount_status(rownum);
		// email
		// firstname
		// lastname
		// lastlogin
		// account creation
		// account_picture
		// account status
		
		
		return this.student;
	}
*/
	// get/set
	//student dao
	public StudentDAO getStudentdao() {
		return studentdao;
	}

	@Override
	public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
