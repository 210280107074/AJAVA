import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class jdbc1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Dhruvil@23";
        try {
            // Class.forName("com.mysql.jdbc.Driver");

            Connection cn = DriverManager.getConnection(url, user, password);
            // System.out.println("Connection established successfully");
            Statement stm = cn.createStatement();
            String query = "CREATE DATABASE IF NOT EXISTS mydb45";
            stm.execute(query);
            System.out.println("Database created successfully");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
