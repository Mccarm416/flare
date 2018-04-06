package flare.model.assignments;


import java.util.Date;

/* Flare: Student Web Application - Course
 * By: GBC Dream Team
 * Gregory Uchitel, Jamie Massel, Matthew McCarthy, Michael van Dyke, and Sean Dougan
 * 
 * Purpose: properties for assignments
 */


public class Assignment {
	
	private int assignmentID;
	private int courseID;
	private String assignmentName;
	private Date dueDate;
	private double grade; 
	private double gradeWeight;
	
	public int getAssignmentID() {
		return assignmentID;
	}
	
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}
	
	public int getCourseID(){
		return courseID;
	}
	
	public void setCourseID(int courseID){
		this.courseID = courseID;
	}
	
	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}
	
	public Double getGradeWeight() {
		return gradeWeight;
	}

	public void setGradeWeight(Double gradeWeight) {
		this.gradeWeight = gradeWeight;
	}
	
	
}