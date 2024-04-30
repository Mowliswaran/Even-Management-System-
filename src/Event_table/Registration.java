package Event_table;

import java.util.Date;

public class Registration {
private int id;
private int event_id;
private int participant_id;
private Date date;
public Registration(int id, int event_id, int participant_id, Date date) {
	super();
	this.id = id;
	this.event_id = event_id;
	this.participant_id = participant_id;
	this.date = date;
}

public Registration() {
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getEvent_id() {
	return event_id;
}
public void setEvent_id(int event_id) {
	this.event_id = event_id;
}
public int getParticipant_id() {
	return participant_id;
}
public void setParticipant_id(int participant_id) {
	this.participant_id = participant_id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "Registration [id=" + id + ", event_id=" + event_id + ", participant_id=" + participant_id + ", date=" + date
			+ "]";
}

}