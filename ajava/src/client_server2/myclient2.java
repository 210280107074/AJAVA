
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class myclient2 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 777);
        InputStream obj = s.getInputStream();
        DataInputStream dip = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("hello from client");
        BufferedReader br = new BufferedReader(new InputStreamReader(obj));
        String str;
        // while ((str = obj.read()) != null) {
        //     System.out.println("From Server: " + str);
        // }
        System.out.println(dip.readUTF());
        // br.close();
        s.close();
    }
}
