package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import Databaseconnection.Database_connection;
import Event_table.Event;

public class EventService {
public void addevent(Event event) throws ClassNotFoundException {
	String query="INSERT INTO event_table (event_id,event_name,event_date) values (?,?,?)";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		
		smt.setInt(1,event.getId() );
		smt.setString(2,event.getName() );
		smt.setDate(3, new java.sql.Date(event.getDate().getTime()));
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}

public void updateevent(Event event) throws ClassNotFoundException {
	String query="UPDATE event_table SET event_name= ? , event_date=? WHERE event_id=?";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		smt.setString(1,event.getName() );
		smt.setDate(2,new java.sql.Date(event.getDate().getTime()));
		smt.setInt(3,event.getId());
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}


public void deleteevent(int id) throws ClassNotFoundException {
	String query="DELETE  FROM event_table WHERE event_id=?";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		smt.setInt(1,id);
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}


public List<Event> getallevent() throws ClassNotFoundException{
	List<Event> events=new ArrayList<>();
	String query="Select * from event_table";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		ResultSet rs=smt.executeQuery();
	    while(rs.next()) {
	    	Event event=new Event();
	    	event.setId(rs.getInt("event_id"));
	    	event.setName(rs.getString("event_name"));
	    	event.setDate(rs.getDate("event_date"));
	    	events.add(event);
	    }	
	    }
	
	catch(SQLException e) {
		System.out.println(e);
	}
	return events;


}

}