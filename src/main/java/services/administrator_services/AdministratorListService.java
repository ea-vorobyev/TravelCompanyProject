package services.administrator_services;

import core.Administrator;
import db.dao.AdministratorDAO;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdministratorListService {
    private final static Logger logger = Logger.getLogger(AdministratorListService.class);

    public AdministratorListService() {

    }

    public List<Administrator> getAdministrators() {
        AdministratorDAO administratorDAO = new AdministratorDAO();
        try {
            return administratorDAO.getAll();
        } catch (AdministratorDAO.AdministratorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return Collections.emptyList();
    }

}
