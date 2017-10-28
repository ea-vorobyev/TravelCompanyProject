package servlets.administrator;

import services.administrator_services.AdministratorListService;
import services.administrator_services.CustomerListService;
import servlets.login_servlets.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdministratorListServlet extends HelloServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listAdmin", new AdministratorListService().getAdministrators());
        req.getRequestDispatcher("/administrators.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/webtravel/admin/administrators");
    }

}
