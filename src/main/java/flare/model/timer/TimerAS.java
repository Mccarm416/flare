package flare.model.timer;

import java.sql.Time;
import java.util.Date;

public class TimerAS extends ATimer {

	private int assignment_id;
	
	public TimerAS() {
	}
	
	public TimerAS(int study_session_id, int session_length, Time time, int assignment_id, Date date, int course_id, int user_id) {
        super(study_session_id,session_length,time,date,course_id,user_id);
        this.assignment_id = assignment_id;
        
     } 
	
	public int getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}

	
}
