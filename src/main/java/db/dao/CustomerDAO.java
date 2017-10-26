package db.dao;

import core.Customer;
import db.IConnectionManager;
import db.TomcatConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements IAbstractDAO<Customer> {
    private IConnectionManager manager;
    private final Logger logger;

    public CustomerDAO() {
        manager = TomcatConnectionPool.getInstance();
        logger = Logger.getLogger(CustomerDAO.class);
    }

    public class CustomerDAOException extends Exception {

    }

    @Override
    public List<Customer> getAll() throws CustomerDAOException {
        List<Customer> customerList = new ArrayList<>();
        //logger.info("Log for getAll Customers");
        //logger.debug("LOGGER DEBUG!");
        try (Connection connection = manager.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
            while (resultSet.next()) {
                Customer customer = getCustomer(resultSet);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
        return customerList;
    }

    @Override
    public Customer getByID(int id) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE customer_id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return getCustomer(resultSet);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
    }

    public Customer getByNickName(String nickName) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE nickName = ? ");
            statement.setString(1, nickName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return getCustomer(resultSet);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
    }

    private Customer getCustomer(ResultSet resultSet) throws SQLException {
        return new Customer(
                resultSet.getInt("customer_id"),
                resultSet.getString("first_name"),
                resultSet.getString("nick_name"),
                resultSet.getString("family_name"),
                resultSet.getString("password"),
                resultSet.getString("contact_number"),
                resultSet.getString("town"),
                resultSet.getString("birth_day"),
                resultSet.getString("email"));
    }

    @Override
    public void updateAll(List<Customer> customerList) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE customers SET first_name = ?, nick_name = ?, family_name = ?, password = ?, contact_number = ?, town = ?, birth_day = ?, email = ? WHERE customer_id = ? ");
            for (Customer customer: customerList) {
                setCustomerUpdate(statement, customer);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
    }

    @Override
    public void update(Customer customer) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE customers SET first_name = ?, nick_name = ?, family_name = ?, password = ?, contact_number = ?, town = ?, birth_day = ?, email = ? WHERE customer_id = ? ");
            setCustomerUpdate(statement, customer);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

    public void updateB(Customer customer) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE customers SET first_name = ?, nick_name = ?, family_name = ?, password = ?, contact_number = ?, town = ?, email = ? WHERE customer_id = ?");
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getNickName());
            statement.setString(3, customer.getFamilyName());
            statement.setString(4, customer.getPassword());
            statement.setString(5, customer.getContactNumber());
            statement.setString(6, customer.getTown());
            statement.setString(7, customer.getEmail());
            statement.setInt(8, customer.getCustomer_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

    private void setCustomerUpdate(PreparedStatement statement, Customer customer) throws SQLException {
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getNickName());
        statement.setString(3, customer.getFamilyName());
        statement.setString(4, customer.getPassword());
        statement.setString(5, customer.getContactNumber());
        statement.setString(6, customer.getTown());
        statement.setDate(7, Date.valueOf(customer.getBirthDay()));
        statement.setString(8, customer.getEmail());
        statement.setInt(9, customer.getCustomer_id());
    }

    @Override
    public void deleteAll() throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM customers");
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE customer_id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
    }

    @Override
    public void insertAll(List<Customer> customerList) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customers(first_name, nick_name, family_name, password, contact_number, town, birth_day, email) VALUES(?, ?, ?, ?, NULL , NULL , NULL, NULL)");
            for (Customer customer : customerList) {
                setCustomerInsert(statement, customer);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
    }

    @Override
    public void insert(Customer customer) throws CustomerDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customers(first_name, nick_name, family_name, password, contact_number, town, birth_day, email) VALUES(?, ?, ?, ?, NULL , NULL , NULL, NULL)");
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getNickName());
            statement.setString(3, customer.getFamilyName());
            statement.setString(4, customer.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new CustomerDAOException();
        }
    }

    private void setCustomerInsert(PreparedStatement statement, Customer customer) throws SQLException {
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getNickName());
        statement.setString(3, customer.getFamilyName());
        statement.setString(4, customer.getPassword());
        statement.setString(5, customer.getContactNumber());
        statement.setString(6, customer.getTown());
        statement.setDate(7, Date.valueOf(customer.getBirthDay()));
        statement.setString(8, customer.getEmail());
    }

}
