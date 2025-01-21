import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SubmitServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the GET request
        String name = request.getParameter("name");
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");
        String email = request.getParameter("email");
        
        // Set response type to text/html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Display the form data
        out.println("<h1>Travel Details (GET Request)</h1>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Destination:</strong> " + destination + "</p>");
        out.println("<p><strong>Travel Date:</strong> " + date + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the POST request
        String name = request.getParameter("name");
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");
        String email = request.getParameter("email");
        
        // Set response type to text/html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Display the form data
        out.println("<h1>Travel Details (POST Request)</h1>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Destination:</strong> " + destination + "</p>");
        out.println("<p><strong>Travel Date:</strong> " + date + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
    }
}
