package db;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionManager {
    Connection getConnection() throws SQLException;
    void closeConnection(Connection connection) throws SQLException;
}
