package flare.model.timer;

import java.sql.Time;
import java.util.Date;

public  class ATimer {
	
	private int study_session_id;
	
	private int session_length;
	
	private Time time;
	
	private Date date;
	
	private int course_id;
	
	private int user_id;
	
	public ATimer() {
	}
	
	public ATimer(int study_session_id, int session_length, Time time, Date date, int course_id, int user_id) {
		this.study_session_id = study_session_id;
		this.session_length = session_length;
		this.time = time;
		this.date = date;
		this.course_id = course_id;
		this.setUser_id(user_id);
         
     } 
	
	
	
	public int getStudy_session_id() {
		return study_session_id;
	}

	public void setStudy_session_id(int study_session_id) {
		this.study_session_id = study_session_id;
	}


	public int getSession_length() {
		return session_length;
	}

	public void setSession_length(int session_length) {
		this.session_length = session_length;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
