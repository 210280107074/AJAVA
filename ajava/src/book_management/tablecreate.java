package book_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class tablecreate {
    String url = "jdbc:mysql://localhost:3306/library2";
        String user = "root";
        String password = "Dhruvil@23";
        tablecreate(){
            try {
                Connection cn = DriverManager.getConnection(url, user, password);
                // System.out.println("Connection established successfully");
                Statement stm = cn.createStatement();
                String query = "create table books(BookTitle varchar(20), Authorname varchar(20),Publisher varchar(20), Price int(20))";
                stm.execute(query);
                System.out.println("table created");
            } catch (Exception e) {
                e.printStackTrace(); // Print the stack trace for debugging purposes
            }
        }
        public static void main(String[] args) {
            new tablecreate();
        }
}
