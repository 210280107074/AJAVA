package book_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class priceupdate {
    String url = "jdbc:mysql://localhost:3306/library2";
    String user = "root";
    String password = "Dhruvil@23";
    priceupdate(){
        try{
            Connection cn = DriverManager.getConnection(url, user, password);
            System.out.println("Enter the name of the book for which you want to change the price : ");
            Scanner sc = new Scanner(System.in);
            String book = sc.nextLine();
            System.out.println("Enter new price for "+book+" : ");
            int price = sc.nextInt();
            // UPDATE Books SET Price = 500 WHERE BookTitle = 'dhruvil'
            String query = "UPDATE Books SET Price = " + price +" WHERE BookTitle = '"+book+"'";
            Statement stm = cn.createStatement();
            stm.executeUpdate(query);
            System.out.println();
            System.out.println("price changed successfully...");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new priceupdate();
    }
}
