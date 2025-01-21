package com.travel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h2>Booking Details</h2>");
        // Ideally, you would fetch the booking data from a database here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");

        // Logic to save the booking details to a database can go here.

        response.setContentType("text/html");
        response.getWriter().println("<h2>Booking Confirmed for: " + customerName + "</h2>");
    }
}
