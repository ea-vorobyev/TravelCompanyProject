package services.user_services;

import core.Customer;
import db.dao.CustomerDAO;
import org.apache.log4j.Logger;

import java.util.List;

public class UserService {
    private final Logger logger;

    public UserService() {
        logger = Logger.getLogger(UserService.class);
    }

    public Customer processingUserMenu(String login) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList= null;
        try {
            customerList = customerDAO.getAll();
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        assert customerList != null;
        for(Customer customer: customerList) {
            if(login.equals(customer.getNickName())) {
                return customer;
            }
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
        try {
            customerDAO.updateB(customer);
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

    public void processingTravelListForUser() {

    }

}
