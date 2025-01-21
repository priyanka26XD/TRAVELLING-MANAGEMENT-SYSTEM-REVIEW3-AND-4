import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a User object to store the registration data
        User user = new User(name, email, password);

        // Store the user object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // Redirect to the Profile page
        response.sendRedirect("ProfileServlet");
    }
}
