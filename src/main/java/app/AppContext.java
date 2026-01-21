package app;

import utils.Utils;

import java.sql.*;
import java.util.logging.Logger;

public class AppContext {

    private static final Logger LOGGER = Logger.getLogger("AppContext");

    private AppContext() {}

    private static Connection connection;

    public static void performConnection(String user, String password) throws SQLException {
        if (connection != null)
            connection.close();

        connection = DriverManager.getConnection(Utils.getProperty("CONNECTION_URL"), user, password);
        LOGGER.info("Successfully connected to the db! :D");
    }

    public static Connection getActiveConnection() {
        return connection;
    }
}
