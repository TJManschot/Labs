package nl.belastingdienst.jdbc.database;

import nl.belastingdienst.jdbc.author.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AuthorsDao extends PubsDao {
    public AuthorsDao() {
        table = "authors";
    }

    public List<Author> searchByName(Name name) {
        ResultSet result = search(
                                new String[] { "au_fname",          "au_lname" },
                                new String[] { name.getFirstName(), name.getLastName() }
                            );
        return getListFrom(result);
    }

    public List<Author> searchByCity(String city) {
        return getListFrom(search("city", city));
    }

    public List<Author> searchByState(String state) {
        return getListFrom(search("state", state));
    }

    private List<Author> getListFrom(ResultSet result) {
        List<Author> authors = new LinkedList<>();

        try {
            while(result.next()) {
                authors.add(parseAuthor(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
