package book_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class datainsert {
    datainsert(String BookTitle,String Authorname,String Publisher,int Price){
         String url = "jdbc:mysql://localhost:3306/library2";
        String user = "root";
        String password = "Dhruvil@23";
        try {
            Connection cn = DriverManager.getConnection(url, user, password);
            String query = "insert into books  values (?,?,?,?)";
    
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setString(1, BookTitle);
            pstm.setString(2, Authorname);
            pstm.setString(3, Publisher);
            pstm.setInt(4, Price);
            pstm.executeUpdate();
            System.out.println();
            System.out.println("data inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // new datainsert("abc", "abc", "abx", 20);
    }
}
