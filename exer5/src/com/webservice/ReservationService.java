package com.webservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class ReservationService.
 */
@WebServlet("/ReservationService")
public class ReservationService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationService() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        DatabaseHandler db = new DatabaseHandler();
        String action = request.getParameter("action");
        if (action.equals("Delete reservation")) {
            try {
                int success = db.deleteReservation(request.getParameter("reservationId"));
                // RequestDispatcher view =
                // request.getRequestDispatcher("reservations.jsp");
                if (success == 1) {
                    RequestDispatcher view = request.getRequestDispatcher("deletedOK.jsp");
                    view.forward(request, response);
                } else if (success == 0) {
                    request.setAttribute("problem", "There is no reservation with this ID");
                    RequestDispatcher view = request.getRequestDispatcher("err.jsp");
                    view.forward(request, response);
                } else {
                    request.setAttribute("problem", "Unknown problem. Please try again...");
                    RequestDispatcher view = request.getRequestDispatcher("err.jsp");
                    view.forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("problem", "Unknown exception. Please try again...");
                RequestDispatcher view = request.getRequestDispatcher("err.jsp");
                view.forward(request, response);
            }

        } else if (action.equals("Show")) {

            try {
                ArrayList<String> reservation = db.showReservation(request.getParameter("reservationId"));
                if (reservation.isEmpty()) {
                    request.setAttribute("problem", "There is no reservation with this ID");
                    RequestDispatcher view = request.getRequestDispatcher("err.jsp");
                    view.forward(request, response);
                } else {
                    request.setAttribute("reservation", (ArrayList<String>) reservation);
                    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
                    view.forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("problem", "Unknown exception. Please try again...");
                RequestDispatcher view = request.getRequestDispatcher("err.jsp");
                view.forward(request, response);
            }
        }
    }

}