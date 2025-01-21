import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the user object from the session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // If the user object exists, forward it to the profile.jsp page
        if (user != null) {
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
            dispatcher.forward(request, response);
        } else {
            // If no user data is found in session, redirect to registration form
            response.sendRedirect("register.jsp");
        }
    }
}
