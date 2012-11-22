package com.webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHandler {
    private Statement stmt;
    private Connection con;
    String url = "jdbc:mysql://85.13.138.126:3306/d0155718";
    String user = "d0155718";
    String pwd = "bravewebtech";

    public DatabaseHandler() {
    }

    public void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pwd);

        stmt = con.createStatement();
    }

    public void closeConnection() throws Exception {
        con.close();
    }

    public String getReservedSeats(String _cinema, String _movie) throws Exception {
        initConnection();
        ResultSet result = stmt.executeQuery("SELECT Seats FROM Reservations WHERE Cinema = '" + _cinema
                + "' AND Movie = '" + _movie + "'");

        String ret = "";
        while (result.next()) {
            ret += result.getString("Seats");
            ret += ";";
        }

        closeConnection();

        return ret;
    }

    public int doReservation(String _cinema, String _movie, String _seats, String _name, String _mail, String _phone)
            throws Exception {
        initConnection();

        int success = stmt.executeUpdate(
                "INSERT INTO Reservations (Cinema, Movie, Seats, Name, Mail, Phone) VALUES (\"" + _cinema + "\", \""
                        + _movie + "\", \"" + _seats + "\", \"" + _name + "\", \"" + _mail + "\", \"" + _phone + "\")",
                Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();

        if ((success == 1) && rs.next()) {
            success = rs.getInt(1);
        } else {
            success = -1;
        }
        closeConnection();

        return success;
    }

    public int deleteReservation(String reservationID) throws Exception {
        initConnection();
        int success = stmt.executeUpdate("DELETE FROM Reservations WHERE ID = " + reservationID);
        closeConnection();
        return success;
    }

    public ArrayList<String> showReservation(String reservationID) throws Exception {
        initConnection();
        ResultSet result = stmt.executeQuery("SELECT * FROM Reservations WHERE ID=" + reservationID);

        ArrayList<String> returnQuery = new ArrayList<String>();
        while (result.next()) {
            returnQuery.add(result.getString("ID"));
            returnQuery.add(result.getString("Cinema"));
            returnQuery.add(result.getString("Movie"));
            returnQuery.add(result.getString("Seats"));
            returnQuery.add(result.getString("Name"));
            returnQuery.add(result.getString("Mail"));
            returnQuery.add(result.getString("Phone"));

        }
        closeConnection();

        return returnQuery;
    }
}
