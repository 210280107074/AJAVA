package book_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class deleteRecord {
    String url = "jdbc:mysql://localhost:3306/library2";
    String user = "root";
    String password = "Dhruvil@23";
    deleteRecord(){
        try{
            Connection cn = DriverManager.getConnection(url, user, password);
            System.out.println("Enter the BookTitle of a record that you want to delete : ");
            Scanner sc  = new Scanner(System.in);
            String name = sc.nextLine();
            String query = "Delete from Books where BookTitle = '"+name + "'";
            Statement stm = cn.createStatement();
            stm.executeUpdate(query);
            System.out.println();
            System.out.println("Record deleted successfully !!!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new deleteRecord();
    }
}
