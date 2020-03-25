package Task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnectionPreConditions {
    public Connection getConnection() {
        return connection;
    }

    private Connection connection;
    private Statement statement;

    public CreateConnectionPreConditions() {
        super();
        createConnection();
        createTable("goods","goodsName","String","price",1);
        createTable("clients","clientsName","String","age",1);
        createTable("orders","ordersName","String","orderID",1);
    }

    public Statement getStatement() {
        return statement;
    }

    public void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_orders", "root", "admin");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private <A,B> void createTable(String tableName, String firstParamName,A firstParamValue,String secParamName,B secParamValue) {
        String firstParamToAdd = "";
        String secParamToAdd = "";
        String firstParam = firstParamValue.getClass().getName();
        String secParam = secParamValue.getClass().getName();
        if (firstParam.contains("Integer")) {
            firstParamToAdd = firstParamName + " INT NOT NULL";
        } else if (firstParam.contains("String")) {
            firstParamToAdd = firstParamName + " VARCHAR(64) NOT NULL";
        }
        if (secParam.contains("Integer")) {
            secParamToAdd = secParamName + " INT NOT NULL";
        } else if (secParam.contains("String")) {
            secParamToAdd = secParamName + " VARCHAR(64) NOT NULL";
        }
        try {
            System.out.println(firstParamToAdd);
            System.out.println(secParamToAdd);
            statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName +
                    "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    firstParamToAdd + "," +
                    secParamToAdd +");"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
