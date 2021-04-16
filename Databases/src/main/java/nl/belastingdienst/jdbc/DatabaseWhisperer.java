package nl.belastingdienst.jdbc;

import nl.belastingdienst.jdbc.author.*;
import nl.belastingdienst.jdbc.database.AuthorsDao;

import java.sql.SQLException;

public class DatabaseWhisperer {
    public static void main(String[] args) {
        try {
            for( Author author : AuthorsDao.getInstance().findByName(new Name().firstName("Marjorie").lastName("Green"))) {
                System.out.println(author.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
