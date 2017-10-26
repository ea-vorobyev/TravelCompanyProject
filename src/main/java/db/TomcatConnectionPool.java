package db;

import db.dao.AdministratorDAO;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TomcatConnectionPool implements IConnectionManager{
    private static DataSource dataSource;
    private static final Logger logger;

    static {
        logger = Logger.getLogger(TomcatConnectionPool.class);
    }

    private TomcatConnectionPool() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/TravelDB");
        } catch (NamingException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

    private static class Holder {
        private static final TomcatConnectionPool INSTANCE = new TomcatConnectionPool();
    }

    public static TomcatConnectionPool getInstance()  {
        return Holder.INSTANCE;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

}
