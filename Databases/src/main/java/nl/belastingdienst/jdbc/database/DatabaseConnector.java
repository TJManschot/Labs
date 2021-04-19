package nl.belastingdienst.jdbc.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnector {
    static Properties properties = new Properties();

    private static String USER;
    private static String PASSWORD;
    private static String URL;

    static {
        try (InputStream file = DatabaseConnector.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(file);
            PASSWORD = properties.getProperty("password");
            USER = properties.getProperty("user");
            URL = properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Connection connection;

    DatabaseConnector() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }



}
