package webapp;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericServletDemo extends GenericServlet {

    private UserValidationService userValidationService = new UserValidationService();

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("---------post");

        boolean isValid = userValidationService.isValidUser(servletRequest.getParameter("username"),
                servletRequest.getParameter("password"));
        if (isValid) {

            PrintWriter out = servletResponse.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Yahoo!!!!!!!!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Successful login");
            out.println("</body>");
            out.println("</html>");

            //      servletRequest.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(servletRequest, servletResponse);
        } else {

            PrintWriter out = servletResponse.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Yahoo!!!!!!!!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Please try again");
            out.println("</body>");
            out.println("</html>");

            //    servletRequest.getRequestDispatcher("WEB-INF/views/login.jsp").forward(servletRequest, servletResponse);

        }

    }
}
