package servlets.login_servlets;

import services.login_services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CheckIn - get");
        req.getRequestDispatcher("/checkIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("nickName");
        String firstName = req.getParameter("firstName");
        String familyName = req.getParameter("familyName");
        String password = req.getParameter("password");

        req.getSession().setAttribute("passwordError", "Password");
        if(password != null && password.length()<6) {
            req.getSession().setAttribute("passwordError", "Не менее 6 символов");
            ((HttpServletResponse)resp).sendRedirect("/webtravel/checkIn");
        } else {
            boolean checkUser = false;
            if(login != null && firstName != null && familyName != null) {
                checkUser = new RegistrationService().checkUser(login, firstName, familyName, password);
            }
            if(checkUser) {
                req.getSession().setAttribute("isAuth", "customer");
                req.getSession().setAttribute("user", login);
                ((HttpServletResponse)resp).sendRedirect("/webtravel/user");
            } else {
                ((HttpServletResponse)resp).sendRedirect("/webtravel/checkIn");
            }
        }
    }

}
