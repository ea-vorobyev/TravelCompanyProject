package servlets.login_servlets;

import services.login_services.AuthorizationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("nickName");
        String password = req.getParameter("password");
        String user = new AuthorizationService().auth(login, password);

        if ("administrator".equals(user)) {
            req.getSession().setAttribute("isAuth", "administrator");
            req.getSession().setAttribute("user", login);
            ((HttpServletResponse) resp).sendRedirect("/webtravel/admin");
        } else if ("customer".equals(user)) {
            req.getSession().setAttribute("isAuth", "customer");
            req.getSession().setAttribute("user", login);
            ((HttpServletResponse) resp).sendRedirect("/webtravel/user");
        } else {
            ((HttpServletResponse) resp).sendRedirect("/webtravel/auth");
        }
    }

}
