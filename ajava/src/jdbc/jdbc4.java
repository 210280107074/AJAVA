import java.sql.*;
import java.util.Scanner;

public class jdbc4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "Dhruvil@23";
        System.out.println("enter a new user name : ");
        String new_user = new String();
        try (Scanner sc = new Scanner(System.in)) {
            new_user = sc.nextLine();
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            CallableStatement callableStatement = connection.prepareCall("{call insert_data2(?)}");
            callableStatement.setString(1, new_user);
            callableStatement.execute();
            callableStatement.close();
            System.out.println("Stored procedure executed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
