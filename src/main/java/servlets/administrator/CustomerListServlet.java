package servlets.administrator;

import services.administrator_services.CustomerListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listCustomer", new CustomerListService().getCustomers());
        req.getRequestDispatcher("/customers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("delete");
        if(button!=null) {
            int customerID = Integer.valueOf(button);
            new CustomerListService().delete(customerID);
        }
        ((HttpServletResponse)resp).sendRedirect("/webtravel/admin/customers");
    }

}
