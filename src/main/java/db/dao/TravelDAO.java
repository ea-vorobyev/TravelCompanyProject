package db.dao;

import core.Travel;
import db.IConnectionManager;
import db.TomcatConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelDAO implements IAbstractDAO<Travel> {
    private IConnectionManager manager;
    private final Logger logger;

    public TravelDAO() {
        manager = TomcatConnectionPool.getInstance();
        logger = Logger.getLogger(TravelDAO.class);
    }

    public class TravelDAOException extends Exception {

    }

    @Override
    public List<Travel> getAll() throws TravelDAOException {
        List<Travel> travelList = new ArrayList<>();
        Statement statement;
        //logger.debug("LOGGER!!!");
        try (Connection connection = manager.getConnection()) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM travel");
            while (resultSet.next()) {
                Travel travel = getTravel(resultSet);
                travelList.add(travel);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            e.printStackTrace();
            throw new TravelDAOException();
        }
        return travelList;
    }

    @Override
    public Travel getByID(int id) throws TravelDAOException {
        PreparedStatement statement;
        try (Connection connection = manager.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM travel WHERE travel_id = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return getTravel(resultSet);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TravelDAOException();
        }
    }

    private Travel getTravel(ResultSet resultSet) throws SQLException {
        return new Travel(
                resultSet.getInt("travel_id"),
                resultSet.getString("country"),
                resultSet.getString("town"),
                resultSet.getString("level_hotel"),
                resultSet.getString("food"),
                resultSet.getString("rating"),
                resultSet.getInt("quantity"),
                resultSet.getInt("customer"));
    }

    @Override
    public void updateAll(List<Travel> travelList) throws TravelDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE travel SET country = ?, town = ?, level_hotel = ?, food = ?, rating = ?, quantity = ? WHERE travel_id = ? ");
            for (Travel travel: travelList) {
                setTravelUpdate(statement, travel);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TravelDAOException();
        }
    }

    @Override
    public void update(Travel travel) throws TravelDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE travel SET country = ?, town = ?, level_hotel = ?, food = ?, rating = ?, quantity = ? WHERE travel_id = ? ");
            setTravelUpdate(statement, travel);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TravelDAOException();
        }
    }

    public void updateQuantity(int id, int num) throws SQLException, TravelDAOException {
        Travel travel = getByID(id);
        travel.setQuantity(travel.getQuantity()+num);
        update(travel);
    }

    public void updateQuantityPlus(int id) throws SQLException, TravelDAOException {
        Travel travel = getByID(id);
        travel.setQuantity(travel.getQuantity()+1);
        update(travel);
    }

    public void updateQuantityMinus(int id) throws SQLException, TravelDAOException {
        Travel travel = getByID(id);
        travel.setQuantity(travel.getQuantity()-1);
        update(travel);
    }

    private void setTravelUpdate(PreparedStatement statement, Travel travel) throws SQLException {
        statement.setString(1, travel.getCountry());
        statement.setString(2, travel.getTown());
        statement.setString(3, travel.getLevelHotel());
        statement.setString(4, travel.getFood());
        statement.setString(5, travel.getRating());
        statement.setInt(6, travel.getQuantity());
        statement.setInt(7, travel.getTravel_id());
    }

    @Override
    public void deleteAll() throws TravelDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM travel");
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TravelDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws TravelDAOException {
        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM travel WHERE travel_id = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TravelDAOException();
        }
    }

    @Override
    public void insertAll(List<Travel> travelList) throws TravelDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO travel(travel_id, country, town, level_hotel, food, rating, quantity, customer) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            for (Travel travel : travelList) {
                setTravelInsert(statement, travel);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TravelDAOException();
        }
    }

    @Override
    public void insert(Travel travel) throws TravelDAOException {
        try (Connection connection = manager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO travel(travel_id, country, town, level_hotel, food, rating, quantity, customer) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            setTravelInsert(statement, travel);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TravelDAOException();
        }
    }

    private void setTravelInsert(PreparedStatement statement, Travel travel) throws SQLException {
        statement.setString(1, travel.getCountry());
        statement.setString(2, travel.getTown());
        statement.setString(3, travel.getLevelHotel());
        statement.setString(4, travel.getFood());
        statement.setString(5, travel.getRating());
        statement.setInt(6, travel.getQuantity());
        statement.setInt(7, travel.getCustomer());
    }

}
