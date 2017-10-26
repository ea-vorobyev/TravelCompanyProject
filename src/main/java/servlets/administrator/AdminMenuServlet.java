package servlets.administrator;

import core.Administrator;
import services.administrator_services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/menu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = (String) req.getSession().getAttribute("user");
        Administrator administrator = new AdminService().processingAdminMenu(login);
        req.getSession().setAttribute("userMenu", administrator);

        String button;
        button = req.getParameter("town");
        if(button!=null) {
            updateAdministrator(administrator, button);
        }
        button = req.getParameter("number");
        if(button!=null) {
            updateAdministrator(administrator, button);
        }
        button = req.getParameter("email");
        if(button!=null) {
            updateAdministrator(administrator, button);
        }
        ((HttpServletResponse)resp).sendRedirect("/webtravel/admin/menu");
    }

    private void updateAdministrator(Administrator administrator, String button) {
        administrator.setTown(button);
        new AdminService().updateAdministrator(administrator);
    }

}
