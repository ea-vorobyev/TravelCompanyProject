package services.administrator_services;

import core.Administrator;
import db.dao.AdministratorDAO;
import org.apache.log4j.Logger;

import java.util.List;

public class AdminService {
    private final Logger logger;

    public AdminService() {
        logger = Logger.getLogger(AdminService.class);
    }

    public Administrator processingAdminMenu(String login) {
        AdministratorDAO administratorDAO = new AdministratorDAO();
        List<Administrator> administratorList = null;
        try {
            administratorList = administratorDAO.getAll();
        } catch (AdministratorDAO.AdministratorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        assert administratorList != null;
        for(Administrator administrator: administratorList) {
            if(login.equals(administrator.getNickName())) {
                return administrator;
            }
        }
        return null;
    }

    public void updateAdministrator(Administrator administrator) {
        AdministratorDAO administratorDAO = new AdministratorDAO();
        try {
            administratorDAO.updateB(administrator);
        } catch (AdministratorDAO.AdministratorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

}
