package flare.model.notes;

public class NotesUtility {
	
	//Checks the file name to see if it will cause any issues with saving it to the serverz
	public static boolean checkFileName(String fileName) {
		System.out.println("--- NotesUtility.checkFileName() called ---");
		boolean check = true;
		
		if (fileName.contains("\\")) {
			check = false;
		}
		else if (fileName.contains("/")) {
			check = false;
		}
		else if (fileName.contains("?")) {
			check = false;
		}
		else if (fileName.contains("/")) {
			check = false;
		}
		else if (fileName.contains(":")) {
			check = false;
		}
		else if (fileName.contains("*")) {
			check = false;
		}
		else if (fileName.contains("\"")) {
			check = false;
		}
		else if (fileName.contains(">")) {
			check = false;
		}
		else if (fileName.contains("<")) {
			check = false;
		}
		else if (fileName.contains("|")) {
			check = false;
		}
		return check;
	}
	
	//Used to validate if the person downloading the note is the owner of it
	public static boolean checkNoteOwner(Note note, int userId) {
		System.out.println("--- NotesUtility.checkNoteOwner() called ---");
		if (note.getUserId() == userId) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Used to provide the servlet with a files MIME type
	public static String mimeTypeCheck(String extension) {
		System.out.println("--- NotesUtility.mimeTypeCheck() called ---");
		//Microsoft Word
		if (extension.equals("doc")) {
			return "application/msword";
		}
		else if(extension.equals("docx")) {
			return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		}
		
		//Microsoft PowerPoint
		else if (extension.equals("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		else if (extension.equals("pptx")) {
			return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
		}
		
		//Microsoft Excel
		else if (extension.equals("xls")) {
			return "application/vnd.ms-excel";
		}
		
		//Text file
		else if (extension.equals("txt")) {
			return "text/plain";
		}
		
		//PDF
		else if (extension.equals("pdf")) {
			return "application/pdf";
		}
		
		//RAR
		else if (extension.equals("rar")) {
			return "application/x-rar-compressed";
		}
		
		//7Z
		else if (extension.equals("7z")) {
			return "application/x-7z-compressed";
		}
		//Zip
		else if (extension.equals("zip")) {
			return "application/zip";
		}
		return null;
	}

}
