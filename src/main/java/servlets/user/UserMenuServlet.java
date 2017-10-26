package servlets.user;

import core.Customer;
import services.user_services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/menu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = (String) req.getSession().getAttribute("user");
        Customer customer = new UserService().processingUserMenu(login);
        req.getSession().setAttribute("userMenu", customer);

        String button;
        button = req.getParameter("town");
        if(button!=null) {
            customer.setTown(button);
            new UserService().updateCustomer(customer);
        }
        button = req.getParameter("number");
        if(button!=null) {
            customer.setContactNumber(button);
            new UserService().updateCustomer(customer);
        }
        button = req.getParameter("email");
        if(button!=null) {
            customer.setEmail(button);
            new UserService().updateCustomer(customer);
        }
        ((HttpServletResponse)resp).sendRedirect("/webtravel/user/menu");
    }

}
