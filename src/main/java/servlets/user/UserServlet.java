package servlets.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("exitUser");
        if(button!=null) {
            req.getSession().setAttribute("isAuth", null);
            ((HttpServletResponse) resp).sendRedirect("/webtravel");
        } else {
            ((HttpServletResponse) resp).sendRedirect("/webtravel/user");
        }
    }

}
