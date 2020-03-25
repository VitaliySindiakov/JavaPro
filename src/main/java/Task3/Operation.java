package Task3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Operation {
    private Statement statement;
    private Connection connection;

    public Operation(Connection connection) {
        this.connection = connection;
    }

    public void addToTable(String tableName, String firstParam, String secParam, String firstValue, int secValue) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("INSERT INTO " + tableName + " (" + firstParam + "," + secParam + ") VALUES(?, ?)")) {
                st.setString(1, firstValue);
                st.setInt(2, secValue);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addToTable(String tableName, String firstParam, String secParam, String firstValue, String secValue) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("INSERT INTO " + tableName + " (" + firstParam + "," + secParam + ") VALUES(?, ?)")) {
                st.setString(1, firstValue);
                st.setString(2, secValue);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
