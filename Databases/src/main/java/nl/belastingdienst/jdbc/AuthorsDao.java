package nl.belastingdienst.jdbc;

import nl.belastingdienst.jdbc.author.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AuthorsDao {
    private static final String URL = "jdbc:mysql://localhost:3306/pubs?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    private static AuthorsDao authorsDao;
    private Connection connection;

    private AuthorsDao() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static AuthorsDao getInstance() {
        if (authorsDao == null) {
            authorsDao = new AuthorsDao();
        }
        return authorsDao;
    }

    public List<Author> findName(Name name) throws SQLException {
        ResultSet result = find("au_fname", name.getFirstName(),
                                "au_lname", name.getLastName());

        List<Author> authors = new LinkedList<>();

        while(result.next()) {
            authors.add(parseAuthor(result));
        }
        return authors;
    }

    private ResultSet find(String column, String target) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
              "SELECT * "
            + "FROM authors "
            + "WHERE " + column + " = ?;"
        );

        statement.setString(1, target);

        return statement.executeQuery();
    }

    private ResultSet find(String column1, String target1, String column2, String target2) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
              "SELECT * "
            + "FROM authors "
            + "WHERE " + column1 + " = ? "
            + "  AND " + column2 + " = ?;"
        );

        statement.setString(1, target1);
        statement.setString(2, target2);

        return statement.executeQuery();
    }

    private Author parseAuthor(ResultSet result) throws SQLException {
        return new Author()
                .id(result.getString("au_id"))
                .name(parseName(result))
                .address(parseAddress(result))
                .contract(result.getDouble("contract"))
                .phoneNumber(parsePhoneNumber(result));
    }

    private Name parseName(ResultSet result) throws SQLException {
        return new Name()
                .firstName(result.getString("au_fname"))
                .lastName(result.getString("au_lname"));
    }

    private Address parseAddress(ResultSet result) throws SQLException {
        return new Address()
                .address(result.getString("address"))
                .city(result.getString("city"))
                .state(result.getString("state"))
                .zip(result.getInt("zip"));
    }

    private PhoneNumber parsePhoneNumber(ResultSet result) throws SQLException {
        return new PhoneNumber()
                .phoneNumber(result.getString("phone"));
    }
}
