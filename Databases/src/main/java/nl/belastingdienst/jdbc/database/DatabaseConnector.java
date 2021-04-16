package nl.belastingdienst.jdbc.database;

import java.sql.*;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/pubs?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    private Connection connection;

    public DatabaseConnector() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }



}
