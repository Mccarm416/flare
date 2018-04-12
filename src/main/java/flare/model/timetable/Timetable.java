package flare.model.timetable;


public class Timetable {
	
	private int courseID;
	private int timeStart;
	private String room;
	private int timeEnd; 
	private int labLecture;
	private int timeDay;
	private int timetableID;
	
	
	
	
	public int getTimetableID() {
		return timetableID;
	}
	
	public void setTimetableID(int timetableID) {
		this.timetableID = timetableID;
	}
	
	public int getTimeStart() {
		return timeStart;
	}
	
	public void setTimeStart(int timeStart) {
		this.timeStart = timeStart;
	}
	
	public int getTimeDay() {
		return timeDay;
	}
	
	public void setTimeDay(int timeDay) {
		this.timeDay = timeDay;
	}
	public int getCourseID(){
		return courseID;
	}
	
	public void setCourseID(int courseID){
		this.courseID = courseID;
	}
	
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	public int getLabLecture() {
		return labLecture;
	}

	public void setLabLecture(int labLecture) {
		this.labLecture = labLecture;
	}
	
	public int getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(int timeEnd) {
		this.timeEnd = timeEnd;
	}
	
	
	
	
}


