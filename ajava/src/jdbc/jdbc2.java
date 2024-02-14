import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class student {
    public void createTable() {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "Dhruvil@23";
        try {
            Connection cn = DriverManager.getConnection(url, user, password);
            // System.out.println("Connection established successfully");
            Statement stm = cn.createStatement();
            String query = "create table student(sid int(3),name varchar(200),enrollment int(12),semester int(1))";
            stm.execute(query);
            System.out.println("table created");
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging purposes
        }
    }

    public void insertData() {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "Dhruvil@23";
        try {
            Connection cn = DriverManager.getConnection(url, user, password);
            String query = "insert into student (sid,name,enrollment,semester) values (?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, 4);
            pstm.setString(2, "henil");
            pstm.setInt(3, 77);
            pstm.setInt(4, 6);
            pstm.executeUpdate();
           
            System.out.println("data inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readData(){
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "Dhruvil@23";
        try {
            Connection cn = DriverManager.getConnection(url, user, password);
            String query = "select * from student";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            System.out.println("sid  name  enro  semester");
            while(rs.next()){
                System.out.print(rs.getInt(1)+"  ");
                System.out.print(rs.getString(2)+"  ");
                System.out.print(+rs.getInt(3)+"  ");
                System.out.print(rs.getInt(4)+"  ");
                System.out.println();
            }
           
            System.out.println("read successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showTables(){
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "Dhruvil@23";
        try {
            Connection cn = DriverManager.getConnection(url, user, password);
            String query = "show tables";
            Statement stm = cn.prepareStatement(query);
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}

public class jdbc2 {
    public static void main(String[] args) {
        student s1 = new student();
        // s1.createTable();
        // s1.insertData();
        // s1.readData();
        s1.showTables();
    }
}
