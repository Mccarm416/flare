package flare.model.timetable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import flare.dataaccess.FlareDB;
import flare.model.timetable.Timetable;
import flare.model.assignments.Assignment;
import flare.model.courses.Course;

public class TimetableDataAccess {

	public static List<Timetable> GetTimetableListFromCourseList(List<Course> courseList) {
	//returns a list of the timetable for the user.  if there are none it will return null.
			System.out.println("-- GetAssignmentListFromCourseList() called --");
			List<Timetable> timetableList = new ArrayList<Timetable>();
			for(int i = 0; i < courseList.size() -1;  i++) {
				Course course = courseList.get(i);
				int courseID = course.getCourseID();
		
				try {
					JdbcTemplate jdbc = FlareDB.getJdbc();
					String sql = "SELECT * FROM table_course_time WHERE course_id = " + courseID;
					System.out.println("[Executing Query]:" + sql);
				    List<Timetable> dataList = jdbc.query(sql, new ResultSetExtractor<List<Timetable>>(){
				        public List<Timetable> extractData(ResultSet results) throws SQLException, DataAccessException {
				            List<Timetable> dataList = new ArrayList<Timetable>();
				            while (results.next()) {
				            	Timetable timetable = new Timetable();
								timetable.setRoom(results.getString("course_room"));
								timetable.setTimeStart(results.getInt("time_start"));
								timetable.setTimeEnd(results.getInt("time_end"));
								timetable.setTimeDay(results.getInt("time_day"));
								timetable.setLabLecture(results.getInt("lab_lecture"));
								timetable.setCourseID(results.getInt("course_id"));
								timetable.setTimetableID(results.getInt("course_time_id"));
								System.out.println("Creating timetable: " + timetable.getRoom()  + timetable.getTimeStart());
								timetableList.add(timetable);		
							}
				            return dataList;
				        } 
				    });
				} catch (Exception e) {
					System.out.println("Error!");
					System.out.println(e);
					return null;
					
				}
				System.out.println("Returning " + timetableList.size() + "timetables");
			}
			return timetableList;
	}
	//Inserts a single timetable into the db
		public static void InsertTimetableIntoDB(int courseID, int timeStart, int timeEnd, String room, int labLecture, int timeDay) throws Exception{
			System.out.println("-- InsertTimetableIntoDB called --");
			
			try{
				JdbcTemplate jdbc = FlareDB.getJdbc();
				//Set the SQL variables
				String sql = String.format("INSERT INTO table_course_time (course_id,time_start,time_end, course_room, lab_lecture,time_day) VALUES "+"('%1$s', '%2$s', '%3$s','%4$s', '%5$s', '%6$s')",
						courseID, timeStart, timeEnd, room, labLecture, timeDay);
				System.out.println("[Executing Query]:" + sql);
				jdbc.update(sql);
				System.out.println("Timetable created - " + courseID);
			} catch (Exception e) {
				System.out.println("Error!");
				System.out.println(e);
			}

		}
		//deletes a single timetable from the db
		public static void DeleteTimetableFromDB(int timetableID) throws Exception{
			System.out.println("-- DeleteTimetableFromDB() called --");

			try{
				JdbcTemplate jdbc = FlareDB.getJdbc();

				String sql = String.format("DELETE FROM table_course_time WHERE course_time_id=  %1$s", timetableID);
				System.out.println("[Executing Query]:" + sql);
				jdbc.execute(sql);
				System.out.println("Assignment Deleted - " + timetableID);
			} catch (Exception e) {
				System.out.println("Error!");
				System.out.println(e);
			}

		}
		
}
