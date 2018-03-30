package flare.model.notes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import flare.data.FlareDB;

public class NotesDAO {

	public static boolean insertNote(Note note){
		boolean check = false;
		//Inserts a note into the database
		try{
			Connection connection = FlareDB.startConnection();
			connection = FlareDB.startConnection();
			//Set the SQL variables
			
			String sql = "INSERT INTO table_note(note_id, user_id, original_file_name, file_name, course_name, description, file_extension) VALUES " + "(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, note.getNoteId());
			preparedStatement.setInt(2, note.getUserId());
			preparedStatement.setString(3, note.getOriginalFileName());
			preparedStatement.setString(4, note.getFileName());
			preparedStatement.setString(5, note.getCourseName());
			preparedStatement.setString(6, note.getDescription());
			preparedStatement.setString(7, note.getFileExtension());
			preparedStatement.executeUpdate();
			System.out.println("Note created");
			check = true;
		} catch (Exception e) {
			System.out.println("*** Error! ***");
			System.out.println(e);
		}
		
		return check;
	}
	
	public static ArrayList<Note> getUserNotes(int userId) {
		ArrayList<Note> notes = new ArrayList<Note>();
		
		try {
			ResultSet results;
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_note WHERE user_id = " + userId;
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					Note note = new Note();
					note.setNoteId(results.getInt("note_id"));
					note.setUserId(results.getInt("user_id"));
					note.setOriginalFileName(results.getString("original_file_name"));
					note.setFileName(results.getString("file_name"));
					note.setCourseName(results.getString("course_name"));
					note.setDescription(results.getString("description"));
					note.setFileExtension(results.getString("file_extension"));
					notes.add(note);
				}
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		
		System.out.println("Returning notes with a size of: " + notes.size());
		return notes;
	}
}
