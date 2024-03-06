package book_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbcreate {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "Dhruvil@23";
    dbcreate(){
        try (Connection cn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            // Class.forName(com.mysql.jdbc.Driver);
            System.out.println("Connection established successfully");
            Statement stm = cn.createStatement();
            String query = "CREATE DATABASE IF NOT EXISTS library2";
            stm.execute(query);
            System.out.println("Database created successfully");
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new dbcreate();
    }
}
