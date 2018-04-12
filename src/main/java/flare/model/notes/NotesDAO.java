package flare.model.notes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import flare.dataaccess.FlareDB;


public class NotesDAO {
	
	//Inserts a note into the database
	public static boolean insertNote(Note note){
		System.out.println("--- NotesDAO.insertNote() called ---");
		boolean check = false;
		try{
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = String.format("INSERT INTO table_note(note_id, user_id, original_file_name, file_name, course_name, description, file_extension, file_path) VALUES " + 
					"(%1$s, %2$s, '%3$s', '%4$s', '%5$s', '%6$s', '%7$s', '%8$s')",
					note.getNoteId(),note.getUserId(), note.getOriginalFileName(), note.getFileName(), note.getCourseName(), note.getDescription(), note.getFileExtension(), note.getFilePath());
			System.out.println("[Executing SQL]:" + sql);
			jdbc.update(sql);
			System.out.println("Note inserted into the database!");
			check = true;
		} catch (Exception e) {
			System.out.println("*** Error! ***");
			e.printStackTrace();
		}
		return check;
	}
	
	//Returns all of the 'notes' owned by a user as a list when given a userId. Returns a List with size 0 if none were found.
	public static List<Note> getUserNotes(int userId) {
		System.out.println("--- NotesDAO.getUserNotes() called ---");

		List<Note> notes = new ArrayList<Note>();
		
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = "SELECT * FROM table_note WHERE user_id = " + userId;
			System.out.println("[Executing SQL]:" + sql);
			
		    notes = jdbc.query(sql, new ResultSetExtractor<List<Note>>(){
		        public List<Note> extractData(ResultSet results) throws SQLException, DataAccessException {
		            List<Note> dataList = new ArrayList<Note>();
		            while(results.next()) {
		        		Note note = new Note();
						note.setNoteId(results.getInt("note_id"));
						note.setUserId(results.getInt("user_id"));
						note.setOriginalFileName(results.getString("original_file_name"));
						note.setFileName(results.getString("file_name"));
						note.setCourseName(results.getString("course_name"));
						note.setDescription(results.getString("description"));
						note.setFileExtension(results.getString("file_extension"));
						note.setFilePath(results.getString("file_path"));
						dataList.add(note);
		            }
		            return dataList;
        		}
	        }); 
			
		} catch (Exception e) {
			System.out.println("*** Error! ***");
			e.printStackTrace();		}
		
		System.out.println("Returning notes with a size of: " + notes.size());
		return notes;
	}
	
	//Attempts to find a Note in the database when given it's note_id. Returns null if nothing was found.
	public static Note getNote(int noteId) {
		System.out.println("--- getNote() called ---");
		Note note = new Note();
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc(); 
			String sql = "SELECT * FROM table_note WHERE note_id = " + noteId;
			System.out.println("[Executing SQL]:" + sql);
			note = jdbc.query(sql, new ResultSetExtractor<Note>() {
				public Note extractData(ResultSet results) throws SQLException, DataAccessException {
					Note note = null;
					while(results.next()) {
						note = new Note();
						note.setNoteId(results.getInt("note_id"));
						note.setUserId(results.getInt("user_id"));
						note.setOriginalFileName(results.getString("original_file_name"));
						note.setFileName(results.getString("file_name"));
						note.setCourseName(results.getString("course_name"));
						note.setDescription(results.getString("description"));
						note.setFileExtension(results.getString("file_extension"));
						note.setFilePath(results.getString("file_path"));
						System.out.println("Note found!");
					}
					return note;
				}
			});

		} catch (Exception e) {
			System.out.println("*** Error! ***");
			e.printStackTrace();
			return null;
		}
		return note;
	}
}
