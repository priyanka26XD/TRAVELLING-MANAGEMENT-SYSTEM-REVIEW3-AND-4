package com.travel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection details (Modify as per your setup)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/travel_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    // Display registration form (GET request)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Registration Form</h2>");
        response.getWriter().println("<form action='/TravelManagementSystem/register' method='POST'>");
        response.getWriter().println("Name: <input type='text' name='name' required><br>");
        response.getWriter().println("Email: <input type='email' name='email' required><br>");
        response.getWriter().println("Password: <input type='password' name='password' required><br>");
        response.getWriter().println("Confirm Password: <input type='password' name='confirmPassword' required><br>");
        response.getWriter().println("<input type='submit' value='Register'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    // Process form submission (POST request)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            response.getWriter().println("<h3>Passwords do not match. Please try again.</h3>");
            return;
        }

        // Save the user details to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Prepare SQL query to insert user details into the database
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, password); // In production, hash the password

                // Execute the query
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    response.getWriter().println("<h3>Registration successful! You can now login.</h3>");
                } else {
                    response.getWriter().println("<h3>Registration failed. Please try again.</h3>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error occurred: " + e.getMessage() + "</h3>");
        }
    }
}
