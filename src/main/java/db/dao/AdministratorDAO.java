package db.dao;

import core.Administrator;
import db.IConnectionManager;
import db.TomcatConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDAO implements IAbstractDAO<Administrator> {
    private IConnectionManager manager;
    private final Logger logger;

    public AdministratorDAO() {
        manager = TomcatConnectionPool.getInstance();
        logger = Logger.getLogger(AdministratorDAO.class);
    }

    public class AdministratorDAOException extends Exception {

    }

    @Override
    public List<Administrator> getAll() throws AdministratorDAOException {
        List<Administrator> administratorList = new ArrayList<>();
        try (Connection connection = manager.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM administrators");
            while (resultSet.next()) {
                Administrator administrator = getAdministrator(resultSet);
                administratorList.add(administrator);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
        return administratorList;
    }

    @Override
    public Administrator getByID(int id) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM administrators WHERE admin_id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return getAdministrator(resultSet);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    public Administrator getByNickName(String nickName) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM administrators WHERE admin_id = ? ");
            statement.setString(1, nickName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return getAdministrator(resultSet);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    private Administrator getAdministrator(ResultSet resultSet) throws SQLException {
        return new Administrator(
                resultSet.getString("first_name"),
                resultSet.getString("nick_name"),
                resultSet.getString("family_name"),
                resultSet.getString("password"),
                resultSet.getString("town"),
                resultSet.getString("birth_day"),
                resultSet.getString("email"));
    }

    @Override
    public void updateAll(List<Administrator> administratorList) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE administrators SET first_name = ?, nick_name = ?, family_name = ?, password = ?, town = ?, birth_day = ?, email = ? WHERE admin_id = ? ");
            for (Administrator administrator: administratorList) {
                setAdministratorUpdate(statement, administrator);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    @Override
    public void update(Administrator administrator) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE administrators SET first_name = ?, nick_name = ?, family_name = ?, password = ?, town = ?, birth_day = ?, email = ? WHERE admin_id = ? ");
            setAdministratorUpdate(statement, administrator);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    public void updateB(Administrator administrator) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE administrators SET first_name = ?, nick_name = ?, family_name = ?, password = ?, town = ?, email = ? WHERE admin_id = ? ");
            statement.setString(1, administrator.getFirstName());
            statement.setString(2, administrator.getNickName());
            statement.setString(3, administrator.getFamilyName());
            statement.setString(4, administrator.getPassword());
            statement.setString(5, administrator.getTown());
            statement.setString(6, administrator.getEmail());
            statement.setInt(7, administrator.getAdmin_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    private void setAdministratorUpdate(PreparedStatement statement, Administrator administrator) throws SQLException {
        statement.setString(1, administrator.getFirstName());
        statement.setString(2, administrator.getNickName());
        statement.setString(3, administrator.getFamilyName());
        statement.setString(4, administrator.getPassword());
        statement.setString(5, administrator.getTown());
        statement.setString(6, administrator.getBirthDay());
        statement.setString(7, administrator.getEmail());
        statement.setInt(8, administrator.getAdmin_id());
    }

    @Override
    public void deleteAll() throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM administrators");
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM administrators WHERE admin_id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    @Override
    public void insertAll(List<Administrator> administratorList) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO administrators(first_name, nick_name, family_name, password, town, birth_day, email) VALUES(?, ?, ?, ?, ?, ?, ?)");
            for (Administrator administrator : administratorList) {
                setAdministratorInsert(statement, administrator);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    @Override
    public void insert(Administrator administrator) throws AdministratorDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO administrators(first_name, nick_name, family_name, password, town, birth_day, email) VALUES(?, ?, ?, ?, ?, ?, ?)");
            setAdministratorInsert(statement, administrator);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AdministratorDAOException();
        }
    }

    private void setAdministratorInsert(PreparedStatement statement, Administrator administrator) throws SQLException {
        statement.setString(1, administrator.getFirstName());
        statement.setString(2, administrator.getNickName());
        statement.setString(3, administrator.getFamilyName());
        statement.setString(4, administrator.getPassword());
        statement.setString(5, administrator.getTown());
        statement.setString(6, administrator.getBirthDay());
        statement.setString(7, administrator.getEmail());
    }

}
