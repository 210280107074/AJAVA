
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class myclient2 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost",4567);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("hello from client");
        dos.flush();
        dos.close();
        s.close();
    }
}
