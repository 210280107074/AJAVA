import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udp_server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(3456);
        System.out.println("server started....");
        byte[] b = new byte[100];
        DatagramPacket dp = new DatagramPacket(b, b.length );
        ds.receive(dp);
        String receivedMessage = new String(dp.getData());
        System.out.println(receivedMessage);
        
    }
}
