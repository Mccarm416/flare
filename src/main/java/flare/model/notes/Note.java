package flare.model.notes;

public class Note {
	
	private int noteId;
	private int userId;
	private String originalFileName;
	private String fileName;
	private String courseName;
	private String description;
	private String fileExtension;
	
	public Note() {
	}

	//Pre-database entry constructor
	public Note(int userId, String originalFileName, String fileName,  String courseName, String description, String fileExtension) {
		this.userId = userId;
		this.originalFileName = originalFileName;
		this.fileName = fileName;
		this.courseName = courseName;
		this.description = description;
		this.fileExtension = fileExtension;
	}

	public Note(int noteId, int userId, String originalFileName, String fileName, String courseName,
			String description, String fileExtension) {
		this.noteId = noteId;
		this.userId = userId;
		this.originalFileName = originalFileName;
		this.fileName = fileName;
		this.courseName = courseName;
		this.description = description;
		this.fileExtension = fileExtension;

	}


	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	
	
	

}
