package services.administrator_services;

import core.Travel;
import db.dao.TravelDAO;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class TravelService {
    private final Logger logger;

    public TravelService() {
        logger = Logger.getLogger(TravelService.class);
    }

    public List<Travel> getTravels() {
        TravelDAO travelDAO = new TravelDAO();
        List<Travel> travelList = null;
        try {
            travelList = travelDAO.getAll();
        } catch (TravelDAO.TravelDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return travelList;
    }

    public void deleteTravel(int id) {
        TravelDAO travelDAO = new TravelDAO();
        try {
            travelDAO.deleteByID(id);
        } catch (TravelDAO.TravelDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

    public void updateQuantity(int id, int num) {
        TravelDAO travelDAO = new TravelDAO();
        try {
            travelDAO.updateQuantity(id, num);
        } catch (TravelDAO.TravelDAOException | SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

}
