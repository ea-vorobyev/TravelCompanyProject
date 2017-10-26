package services.login_services;

import core.Administrator;
import core.Customer;
import db.dao.AdministratorDAO;
import db.dao.CustomerDAO;
import org.apache.log4j.Logger;

import java.util.List;

public class RegistrationService {
    private final Logger logger;

    public RegistrationService() {
        logger = Logger.getLogger(RegistrationService.class);
    }

    public Boolean checkUser(String login, String firstName, String familyName, String password) {
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
                return false;
            }
        }
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = null;
        try {
            customerList = customerDAO.getAll();
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        assert customerList != null;
        for(Customer customer: customerList) {
            if(login.equals(customer.getNickName())) {
                return false;
            }
        }
        String newPassword = new PasswordEncoder().encode(password);
        addCustomer(login, firstName, familyName, newPassword, customerDAO);
        return true;
    }

    private void addCustomer(String login, String firstName, String familyName, String password, CustomerDAO customerDAO) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setNickName(login);
        customer.setFamilyName(familyName);
        customer.setPassword(password);
        try {
            customerDAO.insert(customer);
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

}
