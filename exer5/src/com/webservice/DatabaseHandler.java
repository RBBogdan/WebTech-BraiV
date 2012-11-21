package com.webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHandler {
	private Statement stmt;
	private Connection con;
	String url = "jdbc:mysql://85.13.138.126:3306/d0155718";
	String user = "d0155718";
	String pwd = "bravewebtech";
	
	public DatabaseHandler(){
	}
	
	public void initConnection() throws Exception{	
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pwd); 
	
		stmt = con.createStatement();
	}
	
	public void closeConnection() throws Exception{	
		con.close();
	}
	
	public String getReservedSeats(String _cinema, String _movie) throws Exception{
		initConnection();
		ResultSet result = stmt.executeQuery("SELECT Seats FROM Reservations WHERE Cinema = '"+_cinema+"' AND Movie = '"+_movie+"'");

		String ret = "";
	    while(result.next())
	    {
	    	ret += result.getString("Seats");
	    	ret += ";";
	    } 
	    
	    closeConnection();
		
		return ret;
	}
	
	public int doReservation(String _cinema, String _movie, String _seats, String _name, String _mail, String _phone) throws Exception{
		initConnection();
		
		int success = stmt.executeUpdate("INSERT INTO Reservations (Cinema, Movie, Seats, Name, Mail, Phone) VALUES (\""+_cinema+"\", \""+_movie+"\", \""+_seats+"\", \""+_name+"\", \""+_mail+"\", \""+_phone+"\")",Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = stmt.getGeneratedKeys();
		
		if ((success == 1) && rs.next()) {
			success = rs.getInt(1);
		} else {
			success = -1;
		}
		closeConnection();
		
		return success;
	}
}
