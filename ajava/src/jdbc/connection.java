import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    // JDBC URL, username, and password of MySQL server
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mysql";
    static final String USER = "root";
    static final String PASSWORD = "Dhruvil@23";

    public static void main(String[] args) {
        try {
            // Establish a connection to the MySQL server
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Connected to the MySQL server successfully.");

            // Close the connection
            connection.close();
            System.out.println("Connection closed successfully.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }
    }
}
