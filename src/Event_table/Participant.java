package Event_table;

public class Participant {
private int id;
private String name;
private String email;
private int phone_no;
public Participant(int id, String name, String email, int phone_no) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone_no = phone_no;
}
public Participant() {
	// TODO Auto-generated constructor stub
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPhone_no() {
	return phone_no;
}
public void setPhone_no(int phone_no) {
	this.phone_no = phone_no;
}
@Override
public String toString() {
	return "Participant [id=" + id + ", name=" + name + ", email=" + email + ", phone_no=" + phone_no + "]";
}

}