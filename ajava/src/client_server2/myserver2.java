import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class myserver2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4567);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        String st = dis.readUTF();
        System.out.println(st);
        s.close();
       
    }
}
