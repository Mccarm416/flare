package flare.model.courses;

/* Flare: Student Web Application - Course
 * By: GBC Dream Team
 * Gregory Uchitel, Jamie Massel, Matthew McCarthy, Michael van Dyke, and Sean Dougan
 * 
 * Purpose: Constructors for courses
 * 
 *  */
public class Course {
	
	private String courseName;
	private String courseCode;
	private int courseID;
	private double grade;
	private String professorName1;
	private String professorName2;
	private String professorEmail1;
	private String professorEmail2;
	
	
	public void setCourseInfo(int courseID, String courseName, String courseCode, int grade, 
			String professorName1, String professorName2, String professorEmail1, String professorEmail2){
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseID = courseID;
		this.grade = grade;
		this.professorName1 = professorName1;
		this.professorName2 = professorName2;
		this.professorEmail1 = professorEmail1;
		this.professorEmail2 = professorEmail2;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public int getCourseID(){
		return courseID;
	}
	
	public void setCourseID(int courseID){
		this.courseID = courseID;
	}
	
	public String getProfessorName1() {
		return professorName1;
	}
	
	public void setProfessorName1(String professorName1) {
		this.professorName1 = professorName1;
	}
	
	public String getProfessorName2() {
		return professorName2;
	}
	
	public void setProfessorName2(String professorName2) {
		this.professorName2 = professorName2;
	}
	
	public String getProfessorEmail1() {
		return professorEmail1;
	}
	
	public void setProfessorEmail1(String professorEmail1) {
		this.professorEmail1 = professorEmail1;
	}
	
	public String getProfessorEmail2() {
		return professorEmail2;
	}
	
	public void setProfessorEmail2(String professorEmail2) {
		this.professorEmail2 = professorEmail2;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
}