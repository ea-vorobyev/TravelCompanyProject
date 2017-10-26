package services.administrator_services;

import core.Administrator;
import db.dao.AdministratorDAO;
import org.apache.log4j.Logger;

import java.util.List;

public class AdministratorListService {
    private final Logger logger;

    public AdministratorListService() {
        logger = Logger.getLogger(AdministratorListService.class);
    }

    public List<Administrator> getAdministrators() {
        AdministratorDAO administratorDAO = new AdministratorDAO();
        List<Administrator> administratorList = null;
        try {
            administratorList = administratorDAO.getAll();
        } catch (AdministratorDAO.AdministratorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return administratorList;
    }

}
