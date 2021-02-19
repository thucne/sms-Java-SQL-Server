package schoool.management.system.Tool_Group;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checking_Input_Data {

    public static boolean Check (String field, String value, String table, boolean sign) throws SQLException {
        Connection connection = ConnectionClass.connection();
        String check = "SELECT * FROM " + table + " WHERE " + field +" = '" + value +"'";
        PreparedStatement preparedStatement = connection.prepareStatement(check);

        String showMessage =
                String.format("This %s has already existed in the database, try another %s!", field, field);
        String showMessage1 =
                String.format("This %s has not existed in the database, try another %s!", field, field);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            if (!sign){
                JOptionPane.showMessageDialog(null, showMessage,
                        "Warning!", JOptionPane.WARNING_MESSAGE );
            }
            connection.close();
            return false;
        }
        if (sign){
            JOptionPane.showMessageDialog(null,
                    showMessage1, "Warning!", JOptionPane.WARNING_MESSAGE );

        }
        System.out.println("no");
        connection.close();
        return true;
    }

    public static boolean Check (String field, String value, String table, String message, boolean sign) throws SQLException {
        Connection connection = ConnectionClass.connection();
        String check = "SELECT * FROM " + table + " WHERE " + field +" = '" + value +"'";
        PreparedStatement preparedStatement = connection.prepareStatement(check);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            if (!sign){
                JOptionPane.showMessageDialog(null, message,
                        "Warning!", JOptionPane.WARNING_MESSAGE );
            }            connection.close();
            return false;
        }

        if (sign){
            JOptionPane.showMessageDialog(null,
                    message, "Warning!", JOptionPane.WARNING_MESSAGE );

        }
        System.out.println("no");
        connection.close();
        return true;
    }
}
