package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Databaseconnection.Database_connection;
import Event_table.Event;
import Event_table.Venue;

public class VenueService{
public void addVenue(Venue venue) throws ClassNotFoundException {
	String query="INSERT INTO venue_table (venue_id,venue_name,venue_address,venue_capacity) values (?,?,?,?)";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		
		smt.setInt(1,venue.getId() );
		smt.setString(2,venue.getName() );
		smt.setString(3,venue.getAddress() );
		smt.setInt(4,venue.getCapacity());
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}

public void updatevenue(Venue venue) throws ClassNotFoundException {
	String query="UPDATE venue_table SET venue_name= ? , venue_address=?,venue_capacity=? WHERE venue_id=?";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		smt.setString(1,venue.getName() );
		smt.setString(2,venue.getAddress());
		smt.setInt(3,venue.getCapacity());
		smt.setInt(4,venue.getId());
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}


public void deletevenue(int id) throws ClassNotFoundException {
	String query="DELETE  FROM venue_table WHERE venue_id=?";
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


public List<Venue> getallvenue() throws ClassNotFoundException{
	List<Venue> venues=new ArrayList<>();
	String query="Select * from venue_table";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		ResultSet rs=smt.executeQuery();
	    while(rs.next()) {
	    	Venue venue=new Venue();
	    	venue.setId(rs.getInt("venue_id"));
	    	venue.setName(rs.getString("venue_name"));
	    	venue.setAddress(rs.getString("venue_address"));
	    	venue.setCapacity(rs.getInt("venue_capacity"));
	    	venues.add(venue);
	    }	
	    }
	
	catch(SQLException e) {
		System.out.println(e);
	}
	return venues;


}

}