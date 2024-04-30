package Event_table;

import java.util.Date;

public class Event {
private int id;
private String name;
private Date date;
public Event(int id, String name, Date date) {
	super();
	this.id = id;
	this.name = name;
	this.date = date;
}
public Event() {
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "Event [id=" + id + ", name=" + name + ", date=" + date + "]";
}

}