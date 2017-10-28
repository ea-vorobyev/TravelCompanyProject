package services.administrator_services;

import core.Customer;
import db.dao.CustomerDAO;
import org.apache.log4j.Logger;

import java.util.List;

public class CustomerListService {
    private final Logger logger;

    public CustomerListService() {
        logger = Logger.getLogger(CustomerListService.class);
    }

    public List<Customer> getCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = null;
        try {
            customerList = customerDAO.getAll();
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return customerList;
    }

    public Customer getCustomer(String login) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = null;
        try {
            customer = customerDAO.getByNickName(login);
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return customer;
    }

    public void delete(int id) {
        CustomerDAO customerDAO = new CustomerDAO();
        if (id == 1) {
            
        } else {
            try {
                customerDAO.deleteByID(id);
            } catch (CustomerDAO.CustomerDAOException e) {
                logger.error("This is Error : " + e.getMessage());
            }
        }
    }

    public void updateTown(int customerID, String town) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = null;
        try {
            customer = customerDAO.getByID(customerID);
        } catch (CustomerDAO.CustomerDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        assert customer != null;
        customer.setTown(town);
    }

}
