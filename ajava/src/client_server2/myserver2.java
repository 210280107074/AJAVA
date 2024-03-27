import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class myserver2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(777);
        Socket s = ss.accept();
        System.out.println("Connection Established");
        OutputStream obj = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(obj);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        PrintStream ps = new PrintStream(obj);
        System.out.println(dis.readUTF());
        String str = "Hello Client";
        dos.writeUTF(str);
        ps.close();
        ss.close();
        s.close();

    }
}
