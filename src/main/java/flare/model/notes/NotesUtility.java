package flare.model.notes;

public class NotesUtility {
	
	
	public static boolean checkFileName(String fileName) {
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


}
