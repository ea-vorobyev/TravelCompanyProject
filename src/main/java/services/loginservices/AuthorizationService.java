package services.loginservices;

import com.google.common.base.Strings;
import core.Administrator;
import core.Customer;
import db.dao.AdministratorDAO;
import db.dao.CustomerDAO;
import org.apache.log4j.Logger;

import java.util.List;

public class AuthorizationService {
    private final Logger logger;

    public AuthorizationService() {
        logger = Logger.getLogger(AuthorizationService.class);
    }

    public String auth(String login, String password) {
        if (Strings.isNullOrEmpty(login) || Strings.isNullOrEmpty(password)) {
            return "false";
        }
        String encodedPassword = new PasswordEncoder().encode(password);
        return testUser(login, encodedPassword);
    }

    private String testUser(String login, String newPassword) {
        if (checkAdministrator(login, newPassword)) {
            return "administrator";
        }
        if (checkCustomer(login, newPassword)) {
            return "customer";
        }
        return "false";
    }

    private boolean checkAdministrator(String login, String newPassword) {
        boolean userBool = false;
        AdministratorDAO administratorDAO = new AdministratorDAO();
        List<Administrator> administratorList = null;
        try {
            administratorList = administratorDAO.getAll();
        } catch (AdministratorDAO.AdministratorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        assert administratorList != null;
        for (Administrator administrator : administratorList) {
            if (userBool) {
                return true;
            }
            userBool = logIn(login, newPassword, administrator.getNickName(), administrator.getPassword());
        }
        return userBool;
    }

    private boolean checkCustomer(String login, String newPassword) {
        boolean userBool = false;
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = null;
        try {
            customerList = customerDAO.getAll();
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        assert customerList != null;
        for (Customer customer : customerList) {
            if (userBool) {
                return true;
            }
            userBool = logIn(login, newPassword, customer.getNickName(), customer.getPassword());
        }
        return userBool;
    }

    private boolean logIn(String login, String newPassword, String nickName, String userPassword) {
        if (login.equals(nickName)) {
            if (newPassword.equals(userPassword)) {
                return true;
            }
        }
        return false;
    }

}
