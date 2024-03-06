package book_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class searchbook {
     String url = "jdbc:mysql://localhost:3306/library2";
        String user = "root";
        String password = "Dhruvil@23";
        searchbook(){
            try {
                Connection cn = DriverManager.getConnection(url, user, password);
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the book name : ");
                String str = sc.nextLine();
                String query = "select * from Books where BookTitle = '" + str + "'" ;
                Statement stm = cn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next()){
                    System.out.println("BookTitle : "+rs.getString(1));
                    System.out.println("Authorname : "+rs.getString(2));
                    System.out.println("Publisher : "+rs.getString(3));
                    System.out.println("Price : "+rs.getString(4));
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            new searchbook();
        }
}
