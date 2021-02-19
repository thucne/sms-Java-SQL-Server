package schoool.management.system.Tool_Group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    private static Connection connection;

    public static Connection connection(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SchoolManagementSystem;user=sa;password=sa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
