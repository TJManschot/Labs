package nl.belastingdienst.jdbc.database;

import nl.belastingdienst.jdbc.author.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AuthorsDao extends PubsDao {
    private static AuthorsDao instance;

    private AuthorsDao() {
        table = "authors";
    }

    public static AuthorsDao getInstance() {
        if (instance == null) {
            instance = new AuthorsDao();
        }
        return instance;
    }

    public List<Author> findByName(Name name) throws SQLException {
        ResultSet result = search(
                                new String[] { "au_fname",          "au_lname" },
                                new String[] { name.getFirstName(), name.getLastName() }
                            );

        List<Author> authors = new LinkedList<>();

        while(result.next()) {
            authors.add(parseAuthor(result));
        }
        return authors;
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
