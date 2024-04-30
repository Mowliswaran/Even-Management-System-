package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import Databaseconnection.Database_connection;
import Event_table.Participant;

public class ParticipantService{
public void addParticipant(Participant participant) throws ClassNotFoundException {
	String query="INSERT INTO participant_table (participant_id,participant_name,participant_email,participant_phno) values (?,?,?,?)";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		
		smt.setInt(1,participant.getId() );
		smt.setString(2,participant.getName() );
		smt.setString(3,participant.getEmail() );
		smt.setInt(4,participant.getPhone_no());
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}

public void updateparticipant(Participant participant) throws ClassNotFoundException {
	String query="UPDATE participant_table SET participant_name= ? , participant_email=?,participant_phno=? WHERE participant_id=?";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		smt.setString(1,participant.getName() );
		smt.setString(2,participant.getEmail());
		smt.setInt(3,participant.getPhone_no());
		smt.setInt(4,participant.getId());
		smt.executeUpdate();
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}


public void deleteparticipant(int id) throws ClassNotFoundException {
	String query="DELETE  FROM participant_table WHERE participant_id=?";
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
public List<Participant> getallparticipant() throws ClassNotFoundException{
	List<Participant> participants=new ArrayList<>();
	String query="Select * from participant_table";
	try {
		Connection con=Database_connection.getdbConnection();
		PreparedStatement smt=con.prepareStatement(query);
		ResultSet rs=smt.executeQuery();
	    while(rs.next()) {
	    	Participant participant=new Participant();
	    	participant.setId(rs.getInt("participant_id"));
	    	participant.setName(rs.getString("participant_name"));
	    	participant.setEmail(rs.getString("participant_email"));
	    	participant.setPhone_no(rs.getInt("participant_phno"));
	    	participants.add(participant);
	    }	
	    }
	catch(SQLException e) {
		System.out.println(e);
	}
	return participants;

}

}