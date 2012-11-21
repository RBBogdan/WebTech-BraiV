package com.webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Webservice
 */
@WebServlet("/Webservice")
public class Webservice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Webservice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatabaseHandler db = new DatabaseHandler();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		
		if(action.equals("getReservedSeats")){
			try {
				out.println(db.getReservedSeats(request.getParameter("cinema"), request.getParameter("movie")));
			} catch (Exception e) {
				out.println(e.toString());
			}
		}
		else if(action.equals("doReservation")){
			try {
				db.doReservation(request.getParameter("cinema"), request.getParameter("movie"), request.getParameter("seats"), request.getParameter("name"), request.getParameter("mail"), request.getParameter("phone"));
			} catch (Exception e) {
				out.println(e.toString());
			}
		}
		

	}

}
