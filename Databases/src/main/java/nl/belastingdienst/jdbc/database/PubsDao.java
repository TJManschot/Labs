package nl.belastingdienst.jdbc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PubsDao {
    protected Connection connection = new DatabaseConnector().getConnection();
    protected String table;

    public ResultSet search(String column, String target) throws SQLException {
        return search(new String[] {column}, new String[] {target});
    }

    public ResultSet search(String[] columns, String[] targets) throws SQLException {
        if (columns.length != targets.length || columns.length <= 0) {
            throw new IllegalArgumentException("Please make sure columns and target are equally long and have at least one element.");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT *")
                .append("\nFROM ").append(table)
                .append("\nWHERE ").append(columns[0]).append(" = ?");

        for(int i = 1 ; i < columns.length; i++) {
            sb.append("\nAND ").append(columns[i]).append(" = ?");
        }

        PreparedStatement statement = connection.prepareStatement(sb.toString());
        for(int i = 1; i <= columns.length; i++) {
            statement.setString(i, targets[i - 1]);
        }
        return statement.executeQuery();
    }
}
