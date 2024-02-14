import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class jdbc3 {
    static String url = "jdbc:mysql://localhost:3306/";
    static Connection cn = null;
    static String password = "Dhruvil@23";
    static String user = "root";
    static String db = "mydb";

    public static void connect() throws SQLException {
        try {
            cn = DriverManager.getConnection(url+db, user, password);
            System.out.println("connected");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void createTable(Connection cn, String tname) throws SQLException {
        try {
            Statement stm = cn.createStatement();
            String query = "create table " + tname + "(sid INT, name VARCHAR(255), enrollment INT, semester INT)";
            stm.executeUpdate(query);
            System.out.println("table is created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteData(Connection cn,String tname,int sid) throws SQLException{
        try{
            Statement stm = cn.createStatement();
            String query = "DELETE FROM "+tname + " WHERE sid = " + sid;
            stm.executeUpdate(query);
            System.out.println("data is deleted");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertData(int sid, String name, int enroll, int sem , String tname) throws SQLException {

        try {
            String query = "insert into "+ tname + "(sid,name,enrollment,semester) values (?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, sid);
            pstm.setString(2, name);
            pstm.setInt(3, enroll);
            pstm.setInt(4, sem);
            pstm.executeUpdate();

            System.out.println("data inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update(int sid,String name,String tname) throws SQLException{
        try{
            String query =  "UPDATE " + tname + " SET name = ? WHERE sid = ?";
            PreparedStatement pstm = cn.prepareStatement( query);
            pstm.setString(1, name);
            pstm.setInt(2,sid);
            pstm.executeUpdate();
            System.out.println("Data is updated successfully");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void readData(String tname) {
        try {
            String query = "select * from " + tname;
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            System.out.println("sid  name  enro  semester");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "  ");
                System.out.print(rs.getString(2) + "  ");
                System.out.print(+rs.getInt(3) + "  ");
                System.out.print(rs.getInt(4) + "  ");
                System.out.println();
            }

            System.out.println("read successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteTable(String tableName) throws SQLException {
        try {
            Statement stmt = cn.createStatement();
            String query = "DROP TABLE " + tableName;
            stmt.executeUpdate(query);
            System.out.println("Table " + tableName + " has been deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            connect();
            // createTable(cn, "student1");
            // insertData(1, "John", 12345, 1,"student1");
            // insertData(2, "dhruvil", 178787, 2,"student1");
            // insertData(3, "raj", 784783, 3,"student1");
            // insertData(4, "vasu", 6367, 1,"student1");
            // update(1,"hhhh" ,"student1" );
            // deleteTable("student1");
            deleteData(cn, "student1", 2);
            // readData("student1");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
