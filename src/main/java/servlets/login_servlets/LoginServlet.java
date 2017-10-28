package servlets.login_servlets;

import services.loginservices.AuthorizationService;

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
        String userId = new AuthorizationService().auth(login, password);
        String role = AuthService.getRoleById(userId);
        if ("administrator".equals(role)) {
            req.getSession().setAttribute("isAuth", true);
            req.getSession().setAttribute("role", "administrator");
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
