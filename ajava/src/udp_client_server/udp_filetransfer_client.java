import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udp_filetransfer_client {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket ds = new DatagramSocket()) {
            System.out.println("client connected");
     
             String msg = "messege from client";

            byte b2[] = msg.getBytes();
            InetAddress iad = InetAddress.getByName("localhost");
            DatagramPacket dp2 = new DatagramPacket(b2, b2.length, iad,3456);
            ds.send(dp2);

            byte[] b = new byte[100];
            DatagramPacket dp = new DatagramPacket(b, b.length );
            ds.receive(dp);
            String receivedMessage = new String(dp.getData());
            System.out.println(receivedMessage);
        }

        
    }
}
