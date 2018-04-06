package flare.model.timer;

import java.sql.Time;
import java.util.Date;

public class TimerCO extends TimerABS {
	
	private int course_id;
	
	
	
	public TimerCO(int study_session_id, int session_length, Time time, int course_id, Date date) {
		super(study_session_id, session_length, time,date);
		this.course_id = course_id;
		
	}

	
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
	
	

}
