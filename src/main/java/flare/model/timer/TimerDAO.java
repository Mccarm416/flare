package flare.model.timer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import flare.dataaccess.FlareDB;




public class TimerDAO {

	// Creates a list for times on courses
	public static List<ATimer> GetATimerList (int Course_ID) {
		System.out.println("-- GetATimerList() called --");
		List<ATimer> aTimerList = new ArrayList<ATimer>();
		
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = "SELECT * FROM table_study_session_assignment  WHERE course_id = " + Course_ID;
			System.out.println("Running query...");
		    aTimerList = jdbc.query(sql, new ResultSetExtractor<List<ATimer>>(){
		        public List<ATimer> extractData(ResultSet results) throws SQLException, DataAccessException {
		            List<ATimer> dataList = new ArrayList<ATimer>();
		            while(results.next()) {
						ATimer aTimer = new ATimer();
						aTimer.setUser_id(results.getInt("user_id"));
						aTimer.setCourse_id(results.getInt("course_id"));
						aTimer.setStudy_session_id(results.getInt("session_id"));
						aTimer.setSession_length(results.getInt("session_length"));	
						aTimer.setDate(results.getDate("date"));
						aTimer.setTime(results.getTime("time"));
						dataList.add(aTimer);
		            }
		            return dataList;
				}
			});
		    }catch(Exception e) {
			
				System.out.println("aTimer failed!! \n");
				System.out.println(e);
				return null;
		}
	
		
		return aTimerList;
	}
	
	
	
	// Creates a list for Times on Assignments
	public static List<TimerAS> GetTimerList (int assignment_ID) {
		System.out.println("-- getTimerList() called --");
		List<TimerAS> timerList = new ArrayList<TimerAS>();
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = "SELECT * table_study_session_assignment  WHERE assignment_id = " + assignment_ID;
			System.out.println("Running query...");
		    timerList = jdbc.query(sql, new ResultSetExtractor<List<TimerAS>>(){
		        public List<TimerAS> extractData(ResultSet results) throws SQLException, DataAccessException {
		            List<TimerAS> dataList = new ArrayList<TimerAS>();
		            while (results.next()) {
						TimerAS timerAS = new TimerAS();
						timerAS.setUser_id(results.getInt("user_id"));
						timerAS.setCourse_id(results.getInt("course_id"));
						timerAS.setStudy_session_id(results.getInt("session_id"));
						timerAS.setSession_length(results.getInt("session_length"));
						timerAS.setAssignment_id(results.getInt("assignment_id"));
						timerAS.setDate(results.getDate("date"));
						timerAS.setTime(results.getTime("time"));
						dataList.add(timerAS);
					}
			        return dataList;
		        }
	        });
		}catch(Exception e) {
			
				System.out.println("TimerAS failed!! \n");
				System.out.println(e);
				return null;
			}
			
		return timerList;
	}
	}
	
	
	
	
