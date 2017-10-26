package servlets.administrator;

import services.administrator_services.TravelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TravelListForAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTravel", new TravelService().getTravels());
        req.getRequestDispatcher("/travelForAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button;
        button = req.getParameter("delete");
        if(button!=null) {
            int travelID = Integer.valueOf(button);
            new TravelService().deleteTravel(travelID);
        }
        ((HttpServletResponse)resp).sendRedirect("/webtravel/admin/travels");
    }

}
