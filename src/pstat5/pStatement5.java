package pstat5;

import java.sql.*;

public class pStatement5 {
    public static void main(String[] args) {   //Задание 5 в РТ-3

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        String dbURL = "jdbc:mysql://localhost:3306/ListExpenses";
        String username="root";
        String password="123456";
        Connection myConnection;
        try {
            myConnection = DriverManager.getConnection(dbURL,username, password);
            String template ="Select * from expenses where value > ?";
            PreparedStatement pStatement = myConnection.prepareStatement(template);
            pStatement.setDouble(1, 5000.00);
            ResultSet result = pStatement.executeQuery();
            while (result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2)+" " +result.getString(3)+" "+ result.getString(4));
            }
            myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

