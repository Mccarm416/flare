package flare.model.report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import flare.dataaccess.FlareDB;
 
public class CanvasjsChartData {
 
	private static JdbcTemplate jdbcTemplate;
	static Map<Object,Object> map = null;
	static List<List<DataPointModel>> list = new ArrayList<List<DataPointModel>>();
	static List<DataPointModel> dataPoints1 = new ArrayList<DataPointModel>();
	
	static {
		jdbcTemplate = FlareDB.getJdbc();

	}
 
	public static class DataPointModel {
		
		int userID;
		int course_id;
		int assignment_id;
		int session_length;
		float date;
		
	/*	study_session_id int (11) AUTO_INCREMENT PRIMARY KEY,
	    userid int(11),
	    course_id int (11),
	    assignment_id int (11),
	    session_length int (11),
	    date VARCHAR(50),
	    FOREIGN KEY (userid) REFERENCES users(userid) ON DELETE CASCADE,
	    FOREIGN KEY (assignment_id) REFERENCES table_assignment(assignment_id) ON DELETE CASCADE,
	    FOREIGN KEY (course_id) REFERENCES table_course(course_id) ON DELETE CASCADE
	)*/
		
		public float getX() {
			return date;
		}
		public void setX(float date) {
			this.date = date;
		}
		public int getY() {
			return session_length;
		}
		public void setY(int session_length) {
			this.session_length = session_length;
		}
		public int getUserID() {
			return userID;
		}
		
		public void setUserID(int userID) {
			this.userID = userID;
		}
		
	}
	
	public static class DatabaseConnectionException  extends RuntimeException{
		
		private static final long serialVersionUID = 1L;
 
		public DatabaseConnectionException(String message) {
			super(message);
		}
	}
	
	
	
	private static void getDataPoints(){
        String sql = "select * from table_study_session ORDER BY date DESC";
        
        try {
        	dataPoints1 = jdbcTemplate.query(sql, new RowMapper<DataPointModel>() {
 
				@Override
				public DataPointModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	DataPointModel dataPoint = new DataPointModel();
	     
	            	dataPoint.setX(rs.getFloat("date"));
	            	dataPoint.setY(rs.getInt("session_length")); 
	     
	                return dataPoint;
				}});
        }
        catch(Exception e){
        	dataPoints1 = null;
        	throw new DatabaseConnectionException("Error while getting dataPoints");
        }
		list.add(dataPoints1);
	}
	
	public static List<List<DataPointModel>> getCanvasjsDataList() {
		getDataPoints();
		return list;
	}
	
}       