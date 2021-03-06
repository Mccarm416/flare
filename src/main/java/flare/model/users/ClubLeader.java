package flare.model.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowCallbackHandler;
import flare.dataaccess.UserDAO;


/**
 * 
 * @author Sean Dougan
 * @version 3.0
 * @since 1.0
 * This class student contains an inner class of its data access object StudentDAO. StudentDAO inherits from UserDAO -
 * an abstraction class meant to regulate the use of specific user access and functions on the database.
 */
// START OF OUTER
// ################################################################################################################
public class ClubLeader extends User implements MutateAccountType, AccountManagement {
	
	
	private ClubLeaderDAO cldao;
	

	// methods
	
	public void setClDao(ClubLeaderDAO cldao) {
	
		this.cldao = cldao;
	}
	
	public ClubLeaderDAO DB() {
		
		return cldao;
	}

	
//  START OFINNER CLASS
	/**
	 * @version 3.0
	 * @author Sean Dougan
	 * @since 1.0
	 *
	 */
// ###################################################################################################################
	public class ClubLeaderDAO extends UserDAO {
		
		// fields
		private ClubLeaderRowMapper clDataMap;
		
		// methods
		// constructor
	public ClubLeaderDAO() { super();}

 
	/**
	 * @return the row mapper of the current student object
	 */
	public ClubLeaderRowMapper getclDataMap() {
		return clDataMap;
	}

	/**
	 * @param studentMDataMap the rowmapper of the current student object
	 */
	public void setcltDataMap(ClubLeaderRowMapper clDataMap) {
		this.clDataMap = clDataMap;
	}

	// INNER-INNER START
	/** This class is meant to provide a mapping relation in response to a result set parsed by the jdbctemplate.
	 * Because this is a 2nd level inner class, it has access to both the encapsulated student and connection objects
	 * to modify the 1st level properties as the result set is passed in - 1:1 mapping to the database.
	 * @version 3.0
	 * @author Sean
	 * @since 1.0
	 */
	// ############################################################################################################
	public class ClubLeaderRowMapper implements RowCallbackHandler{

		/**
		 * @param the result set passed in from the jdbctemplate in response to query
		 */
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			
			setUserName(rs.getString("username"));
			setPword(rs.getString("pword"));
			setEmail(rs.getString("email"));
			setFirstName(rs.getString("firstname"));
			setLastName(rs.getString("lastname"));
			setAccountCreation(rs.getDate("accountcreation"));
			setDisplayPicture(rs.getString("displaypicture"));
			setAccountStatus(rs.getInt("accountstatus"));
			setCurrentYear(rs.getInt("currentyear"));
			setSemester(rs.getInt("semester"));
			setRoleTitle(rs.getString("roletitle"));
		}
	}
	
	// #############################################################################################################
	// END OF INNER-INNER


	@Override
	public void insertDB() {

String sql = String.format("INSERT INTO table_user(firstname, lastname, email, username, pword, "
		+ "accountcreation, displaypicture, accountstatus, currentyear, semester, fkroleid)"
		+ " VALUES('%1$s', '%2$s', '%3$s', '%4$s', '%5$s', "
		+ "'%6$s', '%7$s', %8$s, %9$s,%10$s, %11$s)" , getFirstName(), getLastName(), getEmail(), getUserName(),
		getPword(), getAccountCreation(), getDisplayPicture(), getAccountStatus(), getCurrentYear(), getSemester(),
		3);

		userDBC.update(sql);
		
	}

	@Override
	public void bindObjectToDB(String username) {
		
		String sql = String.format("SELECT * FROM auth_user WHERE username='%1$s' AND"
				+ " roletitle = 'clubleader'", username);
		userDBC.query(sql, clDataMap);
		
	}

	@Override
	public void updateDB(String username) {
		
		String sql = String.format("UPDATE table_user SET firstname = '%1$s', lastname = '%2$s', email = '%3$s',"
				+ "username = '%4$s', pword = '%5$s' ,accountcreation = '%6$s', displaypicture = '%7$s', accountstatus = '%8$s',"
				+ " currentyear = '%9$s', semester = '%10$s', fkroleid = %11$s WHERE username = '" + username + "' " , getFirstName(), getLastName(), getEmail(), getUserName(),
		getPword(), getAccountCreation(), getDisplayPicture(), getAccountStatus(), getCurrentYear(), getSemester(),
		1);
	
		userDBC.update(sql);
	}

	@Override
	public void deleteDB() {
	
		String sql = String.format("DELETE FROM table_user WHERE username = '%1$s'", getUserName());
		
		userDBC.update(sql);
	}
	
	}
	// #############################################################################################################
	// END OF INNER

}
// ##################################################################################################################
// END OF OUTER

