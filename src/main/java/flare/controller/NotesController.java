package flare.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import flare.messaging.ChatMessageDAO;
import flare.model.courses.Course;
import flare.model.courses.CoursesDataAccess;
import flare.model.notes.Note;
import flare.model.notes.NotesDAO;
import flare.model.notes.NotesUtility;
import flare.model.users.Student;

@Controller
public class NotesController implements HandlerExceptionResolver{

	@RequestMapping("/notes")
	public String notes(Model model) {
		//Create dummy student
		Student currUser = ChatMessageDAO.searchUserId(1);
		//Add the users information the model
		ArrayList<Note> notes = NotesDAO.getUserNotes(currUser.getUserId());
		model.addAttribute("noteList", notes);
		List<Course> currUserCourses = CoursesDataAccess.GetCourseList(currUser.getUserId());
		model.addAttribute("courseList", currUserCourses);
		
		return "notes";
	}
	
	@RequestMapping("/notesUpload")
	public String notesUpload( @RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		//Used for handling a file upload from notes.jsp's form 'noteSubmission' 
		//Vairables
		String message; //User to display a message to the user about the status of the upload
		String fileCourse;
		String fileName;
		String originalFileName = file.getOriginalFilename();
		String fileDescription = request.getParameter("fileDescription");
		
		//Create a dummy student
		Student currUser = ChatMessageDAO.searchUserId(1);
		//Add the users information to the model
		List<Course> currUserCourses = CoursesDataAccess.GetCourseList(currUser.getUserId());
		model.addAttribute("courseList", currUserCourses);
		ArrayList<Note> notes = NotesDAO.getUserNotes(currUser.getUserId());
		model.addAttribute("noteList", notes);
		
		//Check to see if data was passed from the form
		if (request.getParameterMap().containsKey("fileName")) {
			fileName = request.getParameter("fileName");
			
		}
		else {
			message = "No file name entered";
			model.addAttribute("message", message);
			return "notes";
		}
		if (request.getParameterMap().containsKey("fileCourse")) {
			fileCourse = request.getParameter("fileCourse");
		}
		else {
			message = "No course selected";
			model.addAttribute("message", message);
			return "notes";
		}
		
		//Database length compatability checks
		if(originalFileName.length() > 64) {
			message = "Original file name cannot be greater than 64 characters";
			model.addAttribute("message", message);
			return "notes";
		}
		else if (fileName.length() > 64) {
			message = "File name cannot be greater than 64 characters";
			model.addAttribute("message", message);
			return "notes";
		}
		else if (fileDescription.length() > 64) {
			message = "File name cannot be greater than 64 characters";
			model.addAttribute("message", message);
			return "notes";
		}
		
		//Checks to see if the fileName contains any characters you cannot save file names with.
		if(!NotesUtility.checkFileName(fileName)) {
			message = "File name cannot contain any of the following characters: \\ / \" : | * < >";
			return "notes";
		}
		
		try {
			//Get the file and convert to bytes
			byte[] bytes = file.getBytes();
			//Checks to see if a file was uploaded based on the size of it. file.isEmpty and file != null did not seem to work
			if(bytes.length > 0) {
				//Get the directory of the server then create a directory there to store the uploaded file (SERVER LOCATION/userFiles/USERNAME/*FILE*)
				String rootPath = System.getProperty("catalina.home");
				File directory = new File(rootPath + File.separator + "userFiles" + File.separator + currUser.getUsername());
				//Check to see if the directory already exists and makes it if it doesn't
				if (!directory.exists()) {
					directory.mkdirs();
				}
				String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
				//Create the file on the server
				File serverFile = new File(directory.getAbsolutePath()  + File.separator + fileName + "." + fileExtension);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("File location = " + serverFile.getAbsolutePath());

				message = "Uploaded file '" + file.getOriginalFilename() + "' successfully! Saved as '" + fileName + "'.";
				
				
				Note note = new Note(currUser.getUserId(), originalFileName, fileName,  fileCourse, fileDescription, fileExtension);
				//Create an entry in the database
				if(!NotesDAO.insertNote(note)) {
					//Database upload failure catch
					System.out.println("-!- Deleting file on the server -!-");
					serverFile.delete();
					message = "Error uploading file";
					model.addAttribute("message", message);
					return "notes";
				}
			}
			
			else {
				message = "No file selected!";
			}
			
		}
		catch (Exception error) {
			message = "Failed to upload  '" + fileName + "'";
			System.out.println(error.getMessage());
		}
		
		model.addAttribute("message", message);
		return "notes";
	}
	
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception exc) {        
        ModelAndView modelAndView = new ModelAndView("file");
        if (exc instanceof MaxUploadSizeExceededException) {
            modelAndView.getModel().put("message", "File size exceeds limit!");
        }
        return modelAndView;
    }
}
