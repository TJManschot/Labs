package nl.belastingdienst.jdbc;

import nl.belastingdienst.jdbc.author.*;
import nl.belastingdienst.jdbc.database.AuthorsDao;

import java.sql.SQLException;

public class DatabaseWhisperer {
    public static void main(String[] args) {
        AuthorsDao authorsDao = new AuthorsDao();
        try {
            for( Author author : authorsDao.searchByName(new Name().firstName("Marjorie").lastName("Green"))) {
                System.out.println(author.toString());
            }
            for( Author author : authorsDao.searchByCity("Oakland")) {
                System.out.println(author.toString());
            }
            for( Author author : authorsDao.searchByState("UT")) {
                System.out.println(author.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
