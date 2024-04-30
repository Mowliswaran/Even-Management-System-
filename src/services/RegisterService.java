package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Databaseconnection.Database_connection;
import Event_table.Registration;

public class RegisterService{
public void addregistration(Registration registration) throws ClassNotFoundException {
	String query="INSERT INTO registration_table (registration_id,event_id,participant_id,registration_date) values (?,?,?,?)";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		smt.setInt(1,registration.getId() );
		smt.setInt(2,registration.getEvent_id() );
		smt.setInt(3,registration.getParticipant_id() );
		smt.setDate(4, new java.sql.Date(registration.getDate().getTime()));
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}

public void updateregistration(Registration registration) throws ClassNotFoundException {
	String query="UPDATE registration_table SET event_id= ? ,participant_id=?, registration_date=? WHERE registration_id=?";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		smt.setInt(1,registration.getId() );
		smt.setInt(2,registration.getEvent_id() );
		smt.setDate(3,new java.sql.Date(registration.getDate().getTime()));
		smt.setInt(4,registration.getId());
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}


public void deleteregistration(int id) throws ClassNotFoundException {
	String query="DELETE  FROM registration_table WHERE registration_id=?";
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


public List<Registration> getallregistration() throws ClassNotFoundException{
	List<Registration> registrations=new ArrayList<>();
	String query="Select * from registration_table";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		ResultSet rs=smt.executeQuery();
	    while(rs.next()) {
	    	Registration registration=new Registration();
	    	registration.setId(rs.getInt("registration_id"));
	      	registration.setEvent_id(rs.getInt("event_id"));
	    	registration.setParticipant_id(rs.getInt("participant_id"));
	    	registration.setDate(rs.getDate("registration_date"));
	    	registrations.add(registration);
	    }	
	    }
	
	catch(SQLException e) {
		System.out.println(e);
	}
	return registrations;


}

}