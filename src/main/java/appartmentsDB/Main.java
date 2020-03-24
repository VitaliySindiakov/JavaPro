package appartmentsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/apartments?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "admin";
    static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            try {
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();
                statement.execute("DROP TABLE IF EXISTS apartment");
                statement.execute("CREATE TABLE IF NOT EXISTS apartment (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                        "address VARCHAR(20) NOT NULL, " +
                        "apartmentsArea INT NOT NULL, " +
                        "roomCount INT(3) NOT NULL," +
                        "price INT NOT NULL)");
                statement.execute("DESC apartment");
                statement.execute("INSERT INTO apartment(address,apartmentsArea,roomCount,price) VALUE('kiev,some street',67,3,150000)");
                statement.execute("INSERT INTO apartment(address,apartmentsArea,roomCount,price) VALUE('brovari,some street2',88,3,250000)");
                statement.execute("INSERT INTO apartment(address,apartmentsArea,roomCount,price) VALUE('fastov,some street3',70,3,175000)");
                statement.execute("DESC apartment");
                statement.execute("SELECT * FROM apartment");
                connection.commit();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}}